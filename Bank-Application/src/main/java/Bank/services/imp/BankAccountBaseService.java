package Bank.services.imp;

import Bank.models.BankAccount;
import Bank.repositories.BankAccountRepository;
import Bank.service.BankAccountService;
import java.math.BigDecimal;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author janne
 */

@Service
public class BankAccountBaseService implements BankAccountService {
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BankAccountBaseService.class);
    
    @Autowired
    private BankAccountRepository repository;

    @Override
    public BankAccount findBalance(String document, String password, String branch, String account) {
        BankAccount bankAccount = this.repository.findBalance(document);
        if(bankAccount.getCustomer().getPassword() == password && bankAccount.getCustomer().getDocument() == document){
            return bankAccount;
        }
        return null;
    }

    @Override
    public Boolean deposit(String branch, String account, String bankCode, Double value) {
        if(value != null && value > 0 && value <= 2000) {
            try {
                this.repository.deposit(branch, account, bankCode, value);
            } catch (Exception ex) {
                this.logger.error(ExceptionUtils.class.getName());
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean withdraw(String branch, String account, String document, String password, Double value) {
        BankAccount bankAccount = this.repository.findBankAccount(branch, account);
        if(bankAccount.getBalance().doubleValue() > value && bankAccount.getCustomer().getPassword() == password){
            try {
                this.repository.withdraw(branch, account, value);
            } catch (Exception ex) {
                this.logger.error(ExceptionUtils.class.getName());
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public BankAccount update(BankAccount source, String branch, String account, String bankCode, Double value) {
        Boolean withdraw = this.withdraw(source.getBankBranch(), source.getAccountNumber() ,source.getCustomer().getDocument(), source.getCustomer().getPassword(), value);
        if(withdraw){
            this.deposit(branch, account, bankCode, value);
        }
        return null;
    }

   
}
