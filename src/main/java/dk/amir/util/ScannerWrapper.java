package dk.amir.util;

import java.util.Scanner;
import java.util.function.Function;


/**
 * Singleton wrapper for the {@link Scanner} class.
 * This ensures a single instance of {@link Scanner} is used throughout the application,
 * preventing multiple unnecessary instances from being created.
 * Implements {@link AutoCloseable} for proper resource management.
 */
public class ScannerWrapper implements AutoCloseable{

    // Singleton instance of ScannerWrapper
    private static final ScannerWrapper INSTANCE;
    // Scanner instance for user input
    private final Scanner scanner;

    /**
     * Returns the singleton instance of ScannerWrapper.
     *
     * @return the single instance of ScannerWrapper.
     */
    public static ScannerWrapper getInstance() {
        return INSTANCE;
    }

    // Private constructor to prevent external instantiation
    private ScannerWrapper(){
        scanner = new Scanner(System.in);
    }

    // Static block to initialize the singleton instance
    static {
        INSTANCE = new ScannerWrapper();
    }


    /**
     * Reads user input from the console after displaying a message and converts it using the provided function.
     *
     * @param message   the message to display before reading input.
     * @param converter a function to convert the input string into the desired type.
     * @param <T>       the type of the converted input.
     * @return the converted input.
     */
    public <T> T getMessage(String message, Function<String, T> converter){
        System.out.println(message);
        try {
            return converter.apply(scanner.nextLine());
        }catch (Exception ex){
            System.out.println("Wrong Input !!!");
            return getMessage(message, converter);
        }
    }

    /**
     * Closes the scanner resource when no longer needed.
     * Should be called when input operations are complete to free system resources.
     */
    @Override
    public void close(){
        scanner.close();
    }
}
