package Module3;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputMismatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        // scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt(); // May throw InputMismatchException
            System.out.println("You entered: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("The input broke... exiting");
        } catch (IllegalStateException e) {
            System.out.println("Input is closed");
        } finally {
            scanner.close(); // Safe to close here since the program is terminating
        }
    }
}