package Bank.presenters;

import Bank.models.Customer;

/**
 *
 * @author janne
 */
public class CustomerPresenter {
    private Long id;
    private String name;
    
    public CustomerPresenter(Customer model) {
        this.id = model.getId();
        this.name = model.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }    
}
