package dk.amir;

import dk.amir.view.ConsoleUI;


public class ApplicationRunner
{
    public static void main( String[] args )
    {
        try(ConsoleUI consoleUI = new ConsoleUI()){
            consoleUI.startMenu();
        }catch (Throwable ex){
            System.out.println("An error occurred while running the application.");
        }
    }
}
