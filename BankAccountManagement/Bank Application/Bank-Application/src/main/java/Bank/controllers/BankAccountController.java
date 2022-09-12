package Bank.controllers;

import Bank.models.BankAccount;
import Bank.presenters.BankAccountPresenter;
import Bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author janne
 */
@RestController
@RequestMapping("/bank")
public class BankAccountController {

    @Autowired
    private BankAccountService service; 
    
    @PutMapping("/balances")
    public ResponseEntity<BankAccount> balance(@RequestParam(value = "document", required = true) String document,
                                                @RequestParam(value = "password", required = true) String password,
                                                @RequestParam(value = "branch", required = true) String branch,
                                                @RequestParam(value = "account", required = true) String account){
		
		BankAccount bankAccount = this.service.findBalance(document, password, branch, account);
                if(bankAccount != null){
                    return new ResponseEntity(bankAccount, HttpStatus.OK); 
                }
                return new ResponseEntity(bankAccount, HttpStatus.BAD_REQUEST); 		
    }
    
    @PutMapping("/deposits")
    public ResponseEntity<?> deposit(@RequestParam(value = "branch", required = true) String branch,
                                       @RequestParam(value = "account", required = true) String account,
                                       @RequestParam(value = "bank-code", required = true) String bankCode,
                                       @RequestParam(value = "value", required = true) Double value){

        Boolean transaction = this.service.deposit(branch, account, bankCode, value);
        if(transaction){
            return new ResponseEntity(HttpStatus.OK);
        } 
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
        
      
    @PutMapping("/withdraws")
    public ResponseEntity<BankAccountPresenter> withdraw(@RequestParam(value = "branch", required = true) String branch,
                                       @RequestParam(value = "account", required = true) String account,
                                       @RequestParam(value = "document", required = true) String document,
                                       @RequestParam(value = "password", required = true) String password,
                                       @RequestParam(value = "value", required = true) Double value){
        Boolean transaction = this.service.withdraw(branch, account, document, password, value);
        if (transaction) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    
    @PutMapping("/transfers")
    public ResponseEntity<BankAccountPresenter> transfer(@RequestBody BankAccount source,
                                                        @RequestParam(value = "branch", required = true) String branch,
                                                        @RequestParam(value = "account", required = true) String account,
                                                        @RequestParam(value = "bank-code", required = true) String bankCode,
                                                        @RequestParam(value = "value", required = true) Double value)   {           
            
        if (source == null || value >2000 || branch == null ||account == null || value <=0 || bankCode == null){
             return new ResponseEntity(HttpStatus.BAD_REQUEST);  
        }
        else{
            BankAccount result = this.service.update(source, branch, account, bankCode, value); 
            return new ResponseEntity(HttpStatus.OK);
        }     
    } 
}
