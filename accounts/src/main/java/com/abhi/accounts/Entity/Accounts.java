package com.abhi.accounts.Entity;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class Accounts extends BaseEntity{

//    @Column(name="customer_id")
    private Long customerId;

//    @Column(name="account_number") //Not Mandatory if coulumn is same in db
    @Id
    private Long accountNumber;

//    @Column(name="account_type")
    private String accountType;

//    @Column(name="branch_address")
    private String branchAddress;
}
