import java.util.*;

public class HeapSort {
    public static void sort(int arr[]) {
        int n = arr.length;
 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }
 
    public static void heapify(int arr[], int n, int i) {
        int largest = i; 
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static int[] generateBestCaseArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static int[] generateWorstCaseArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    public static int[] generateAverageCaseArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < size; i++) {
            int randomIndex = (int) (Math.random() * size);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Date currentDate = new Date();
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose the type of array to sort:");
        System.out.println("1. Best Case (Already Sorted)");
        System.out.println("2. Worst Case (Reverse Sorted)");
        System.out.println("3. Average Case (Random Order)");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = sc.nextInt();

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr;
        switch (choice) {
            case 1:
                arr = generateBestCaseArray(size);
                System.out.println("Best Case Array (Already Sorted):");
                break;
            case 2:
                arr = generateWorstCaseArray(size);
                System.out.println("Worst Case Array (Reverse Sorted):");
                break;
            case 3:
                arr = generateAverageCaseArray(size);
                System.out.println("Average Case Array (Random Order):");
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        printArray(arr);
        
        long t1 = System.currentTimeMillis();
        sort(arr);
        long t2 = System.currentTimeMillis();
        
        System.out.println("Sorted array:");
        printArray(arr);
        
        System.out.println("Time taken for algorithm: " + (t2-t1) + " ms");
    }
}
