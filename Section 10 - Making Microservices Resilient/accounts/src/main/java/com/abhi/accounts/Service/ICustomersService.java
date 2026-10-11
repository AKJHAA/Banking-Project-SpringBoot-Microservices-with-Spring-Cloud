package com.abhi.accounts.Service;

import com.abhi.accounts.dto.CustomerDetailsDto;

public interface ICustomersService {
    /**
     *
     * @param mobileNumber - Input Mobile number
     * @return Customer Details based on a given Mobile number
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
