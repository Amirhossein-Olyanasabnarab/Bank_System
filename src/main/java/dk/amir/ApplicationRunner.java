package dk.amir;

import dk.amir.view.ConsoleUI;

/**
 * Hello world!
 *
 */
public class ApplicationRunner
{
    public static void main( String[] args )
    {
        try(ConsoleUI consoleUI = new ConsoleUI()){
            consoleUI.startMenu();
        }
    }
}
