package Bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Bank.entities.CustomerEntity;

/**
 *
 * @author janne
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    
}
