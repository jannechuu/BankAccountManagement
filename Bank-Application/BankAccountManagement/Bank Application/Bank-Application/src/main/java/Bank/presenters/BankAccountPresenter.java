package Bank.presenters;

import Bank.models.BankAccount;

/**
 *
 * @author janne
 */
public class BankAccountPresenter {
    private Long id;
    private String bankBranch;
    private String accountNumber;
    private Integer bankCode;
    private CustomerPresenter customer;

    public BankAccountPresenter(BankAccount model) {
        if (model != null) {
            this.id = model.getId();
            this.bankBranch = model.getBankBranch();
            this.accountNumber = model.getBankBranch();
            this.bankCode = model.getBankCode();
            if (model.getCustomer() != null){
                this.customer = new CustomerPresenter(model.getCustomer());
            }
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public CustomerPresenter getCustomer() {
        return customer;
    }
    
}
