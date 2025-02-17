package dk.app.view;

import java.util.Scanner;

public class ConsoleUI implements AutoCloseable{
    private final Scanner scanner;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
    }

    public void startMenu(){
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Exit");
                    break;
                case 1:
                    System.out.println("Add new customer");
                    break;
                case 2:
                    System.out.println("Show all customers");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (choice != 0);
    }

    private void printMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("0. Exit");
        System.out.println("1. Add new customers");
        System.out.println("2. Show all customers");
        System.out.println("Please choose one of the  above options:");
    }
    @Override
    public void close() {
        scanner.close();
    }
}
