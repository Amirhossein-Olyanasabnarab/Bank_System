package dk.amir.util;

import java.util.Scanner;


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
     * Closes the scanner resource when no longer needed.
     * Should be called when input operations are complete to free system resources.
     */
    @Override
    public void close(){
        scanner.close();
    }
}
