package dk.amir.view;

import dk.amir.service.CustomerService;
import dk.amir.service.impl.CustomerServiceImpl;
import dk.amir.util.ScannerWrapper;

public class ConsoleUI implements AutoCloseable{
    private final ScannerWrapper scannerWrapper;
    private final CustomerService customerService;
    public ConsoleUI(){
        this.scannerWrapper = ScannerWrapper.getInstance();
        this.customerService = CustomerServiceImpl.getInstance();
    }

    public void startMenu(){
        int choice;
        do {
            printMenu();
            choice = scannerWrapper.getMessage("Enter your choice:", Integer::valueOf);
            switch (choice) {
                case 0:
                    System.out.println("Exit....!!!");
                    break;
                case 1:
                    System.out.println("add customer");
                    break;
                case 2:
                    System.out.println("show customers");
                    break;
                case 3:
                    System.out.println("delete customer");
                    break;
                case 4:
                    System.out.println("edit customer by id");
                    break;
                case 5:
                    System.out.println("get customer by id");
                    break;
                case 6:
                    System.out.println("get customer by name");
                    break;
                case 7:
                    System.out.println("get customer by family");
                    break;
                case 8:
                    System.out.println("get add deleted customers");
                    break;
                case 9:
                    System.out.println("get all active and none-active customers");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (choice != 0);
    }

    private void printMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("1. add Customer");
        System.out.println("2. show all customers");
        System.out.println("3. delete customer");
        System.out.println("4. edit customer by id");
        System.out.println("5. show customer by id");
        System.out.println("6. show customer by name");
        System.out.println("7. show customer by family");
        System.out.println("8. show all deleted customers");
        System.out.println("9. show active & non-active customers");
        System.out.println("0. Exit ");
    }
    @Override
    public void close()  {
        scannerWrapper.close();
    }
}
