/*Create a Java program that implements a binary search algorithm. The program
should accept user input for the target value and search for it in a sorted array. The
program should return the index of the target value if found or a message if not
found.
 */


package in.ineuron.test;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        return -1; // Target value not found
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 9, 11, 15, 23, 38, 56, 72, 91 };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Target value is present at index: " + index);
        } else {
            System.out.println("Target value is not present in the array.");
        }
    }
}

