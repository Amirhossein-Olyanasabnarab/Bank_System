package dk.amir.view.component;

import dk.amir.model.Customer;
import dk.amir.model.RealCustomer;

public class RealCustomerUI extends AbstractCustomerUI{
    public RealCustomerUI(){
        super();
    }
    @Override
    protected Customer additionalGenerateCustomer(String name, String phone, String email) {
        return null;
    }

    @Override
    public void editCustomer(Customer customer) {

    }
}
