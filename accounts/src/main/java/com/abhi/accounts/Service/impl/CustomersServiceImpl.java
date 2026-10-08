package com.abhi.accounts.Service.impl;

import com.abhi.accounts.Entity.Accounts;
import com.abhi.accounts.Entity.Customer;
import com.abhi.accounts.Exception.ResourceNotFoundException;
import com.abhi.accounts.Mapper.AccountsMapper;
import com.abhi.accounts.Mapper.CustomerMapper;
import com.abhi.accounts.Repository.AccountRepository;
import com.abhi.accounts.Repository.CustomerRepository;

import com.abhi.accounts.Service.ICustomersService;
import com.abhi.accounts.Service.client.CardsFeignClient;
import com.abhi.accounts.Service.client.LoansFeignClient;
import com.abhi.accounts.dto.AccountsDto;
import com.abhi.accounts.dto.CardsDto;
import com.abhi.accounts.dto.CustomerDetailsDto;
import com.abhi.accounts.dto.LoansDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     *  @param correlationId - Correlation ID value generated at Edge server
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if(loansDtoResponseEntity != null) {
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if(cardsDtoResponseEntity != null){
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }

        return customerDetailsDto;

    }
}