package Bank.services.imp;

import Bank.entities.CustomerEntity;
import Bank.models.Customer;
import Bank.repositories.CustomerRepository;
import Bank.service.CustomerService;
import java.util.Optional;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author janne
 */

@Service
public class CustomerBaseService implements CustomerService{
    
    @Autowired
    private CustomerRepository repository;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomerBaseService.class);
    
    @Override
    public Customer create(Customer customer) {
        
        CustomerEntity entity = new CustomerEntity(customer);
        entity = this.repository.save(entity);
       
        return entity.toModel();
    }

    @Override
    public Customer update(Customer customer) {
        Optional<CustomerEntity> optEntity = this.repository.findById(customer.getId());
        
        Customer current = optEntity.get().toModel();
        CustomerEntity entity = new CustomerEntity(current);
        entity = this.repository.save(entity);

        return entity.toModel();
    }

    @Override
    public Page<Customer> list(int page, int size) {
        Page<CustomerEntity> results = null;
        Pageable pageable = PageRequest.of(page, size);
        
        results = this.repository.findAll(pageable);
        
            if (results != null) {
                return results.map(CustomerEntity::toModel);
            } 
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception ex) {
            this.logger.error(ExceptionUtils.class.getName());
        }
        return true;
    }

    
}
