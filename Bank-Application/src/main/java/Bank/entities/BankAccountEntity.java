package Bank.entities;

import Bank.models.BankAccount;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author janne
 */

@Entity
@Table(name = "TB_CONTA_BANCARIA")
public class BankAccountEntity implements Serializable  {

    @Id
    @Column(name = "ID_CONTA_BANCARIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NR_AGENCIA")
    private String bankBranch;

    @Column(name = "NR_CONTA")
    private String accountNumber;

    @Column(name = "NR_CODIGO_BANCO")
    private Integer bankCode;

    @Column(name = "NR_SALDO")
    private BigDecimal balance;
    
    @Column(name = "ID_CLIENTE")
    private CustomerEntity customer;

    public BankAccountEntity() {}

    public BankAccountEntity(BankAccount model) {
        if (model != null) {
            this.id = model.getId();
            this.bankBranch = model.getBankBranch();
            this.accountNumber = model.getAccountNumber();
            this.bankCode = model.getBankCode();
            this.balance = model.getBalance();
            if (model.getCustomer() != null) {
                this.customer = new CustomerEntity(model.getCustomer());
            }
        }
    }
    
    public BankAccount toModel() {
        BankAccount model = new BankAccount();

        model.setId(this.id);
        model.setBankBranch(this.bankBranch);
        model.setAccountNumber(this.accountNumber);
        model.setBankCode(this.bankCode); 
        model.setBalance(this.balance);
        if (this.customer != null) {
            model.setCustomer(this.customer.toModel());
        }
          
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
}
