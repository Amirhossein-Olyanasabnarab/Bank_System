package dk.amir.view.component;

import dk.amir.enums.CustomerType;
import dk.amir.model.Customer;
import dk.amir.util.ScannerWrapper;

import java.util.function.Function;

public abstract class AbstractCustomerUI {
    protected final ScannerWrapper scannerWrapper;
    public AbstractCustomerUI(){
        this.scannerWrapper = ScannerWrapper.getInstance();
    }

    public static AbstractCustomerUI fromCustomerType(CustomerType type){
        return switch(type){
            case REAL -> new RealCustomerUI();
            case LEGAL -> new LegalCustomerUI();
        };
    }

    public Customer generateCustomer(){
        String name = scannerWrapper.getMessage("Please enter name:", Function.identity());
        String phone = scannerWrapper.getMessage("Please enter phone number:", Function.identity());
        String email = scannerWrapper.getMessage("Please enter email:", Function.identity());
        return additionalGenerateCustomer(name, phone, email);
    }
    protected  abstract  Customer additionalGenerateCustomer(String name, String phone, String email);
    public abstract void editCustomer(Customer customer);
}
