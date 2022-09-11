package Bank.service;

import Bank.models.Customer;
import org.springframework.data.domain.Page;

/**
 *
 * @author janne
 */
public interface CustomerService {

    public Customer create(Customer customer);

    public Customer update(Customer customer);

    public Page<Customer> list(int page, int size);

    public boolean delete(Long id);
    
}
