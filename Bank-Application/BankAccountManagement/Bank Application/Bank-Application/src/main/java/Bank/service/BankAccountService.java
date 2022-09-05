package Bank.service;

import Bank.models.BankAccount;
import java.math.BigDecimal;

/**
 *
 * @author janne
 */
public interface BankAccountService {

    public BankAccount findBalance(String document, String password, String branch, String account);

    public Boolean deposit(String branch, String account, String bankCode, Double value);

    public Boolean withdraw(String branch, String account, String document, String password, Double value);

    public BankAccount update(BankAccount source, String branch, String account, String bankCode, Double value);
    
}
