package Bank.controllers;

import Bank.models.Customer;
import Bank.presenters.CustomerPresenter;
import Bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service; 
      
    @PostMapping
    public ResponseEntity<CustomerPresenter> create(@RequestBody Customer customer) {           
            
        if (customer != null){
                Customer result = this.service.create(customer); 
                return new ResponseEntity(new CustomerPresenter(result), HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.OK);   
    }
    
    @PutMapping
    public ResponseEntity<CustomerPresenter> update(@RequestBody Customer customer) {           
            
        if (customer != null){
                Customer result = this.service.update(customer); 
                return new ResponseEntity(new CustomerPresenter(result), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.OK);  
    }
        
    @GetMapping
    public ResponseEntity<CustomerPresenter> list(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
      
        Page<Customer> results = this.service.list(page, size);
        
        if (results != null && !results.isEmpty()){
            return new ResponseEntity(results.map(a -> new CustomerPresenter(a)), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    } 
    
  
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean result = this.service.delete(id);

        if (result) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}