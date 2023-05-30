/*10. Write a Java program that reads a set of integers from the user and stores them in a
List. The program should then find the second largest and second smallest elements
in the List.
 * 
 * 
 */


package in.ineuron.test;
import java.util.Scanner;

public class NegativeNumberExceptionHandling03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        try {
            int number = scanner.nextInt();

            if (number < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed.");
            }

            System.out.println("You entered: " + number);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
