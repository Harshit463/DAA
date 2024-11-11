import java.util.Arrays;
import java.util.Scanner;

public class SearchAlgorithms {

    // Sequential (Linear) Search
    public static int sequentialSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i; // Element found at index i
            }
        }
        return -1; // Element not found
    }

    // Binary Search
    public static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if x is at mid
            if (arr[mid] == x) {
                return mid; // Element found at index mid
            }

            // If x is greater, ignore the left half
            if (arr[mid] < x) {
                left = mid + 1;
            }
            // If x is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input element to search
        System.out.print("Enter the element to search: ");
        int x = scanner.nextInt();

        // Sequential Search
        int seqResult = sequentialSearch(arr, x);
        if (seqResult != -1) {
            System.out.println("Element found at index (Sequential Search): " + seqResult);
        } else {
            System.out.println("Element not found (Sequential Search).");
        }

        // Sorting the array for Binary Search
        Arrays.sort(arr);
        System.out.println("Sorted array for Binary Search: " + Arrays.toString(arr));

        // Binary Search
        int binResult = binarySearch(arr, x);
        if (binResult != -1) {
            System.out.println("Element found at index (Binary Search): " + binResult);
        } else {
            System.out.println("Element not found (Binary Search).");
        }

        scanner.close();
    }
}
