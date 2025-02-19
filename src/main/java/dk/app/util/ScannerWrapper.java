package dk.app.util;

import java.util.Scanner;

public class ScannerWrapper implements AutoCloseable{

    //Singleton Pattern
    private static final ScannerWrapper INSTANCE;
    private Scanner scanner;
    public static ScannerWrapper getInstance() {
        return INSTANCE;
    }
    static {
        INSTANCE = new ScannerWrapper();
    }
    private ScannerWrapper() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void close()  {
        scanner.close();
    }
}
