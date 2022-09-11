package Bank.entities;

import Bank.models.Customer;
import java.io.Serializable;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
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
@Table(name = "TB_CLIENTE", catalog = "SCALEUP")

public class CustomerEntity implements Serializable {
    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "NR_CPF_CNPJ")
    private String document;

    @Column(name = "NM_CLIENTE")
    private String name;
       
    @Column(name = "DS_PASSWORD")
    private String password;
   
        
    public CustomerEntity(){}
    
    public CustomerEntity(Customer model){
        if (model != null){
            this.id = model.getId();
            this.name = model.getName();
            this.document = model.getDocument();
            this.password = model.getPassword();
        }
    }
    
    public Customer toModel(){
        Customer customer = new Customer();
         
        customer.setId(this.id);
        customer.setDocument(this.document);
        customer.setName(this.name);
        customer.setPassword(this.password);
                       
        return customer;
    }
}
