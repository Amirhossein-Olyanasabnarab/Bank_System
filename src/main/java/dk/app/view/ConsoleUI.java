package dk.app.view;

import java.util.Scanner;

public class ConsoleUI implements AutoCloseable{
    private final Scanner scanner;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
    }

    private void startMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("0. Exit");
        System.out.println("1. Add new customers");
        System.out.println("2. Show all customers");
    }
    @Override
    public void close() {
        scanner.close();
    }
}
