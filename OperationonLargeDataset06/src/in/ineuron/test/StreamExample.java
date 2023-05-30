/*Write a Java program that uses stream api to perform operations on a large data set,
such as sorting or filtering the data.

*/


package in.ineuron.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Creating a large dataset
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 2000000; i++) {
            numbers.add(i);
        }

        // Filtering the data using Stream API
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);

        // Sorting the data using Stream API
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted numbers: " + sortedNumbers);
    }
}


