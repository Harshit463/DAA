public class HeapSorter {

    private int[] arr;
    private int n;

    public HeapSorter(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
    }

    // Method to perform heap sort
    public void sort() {
        buildMaxHeap();
        for (int i = n - 1; i > 0; i--) {
            swap(0, i);
            n--;
            heapify(0);
        }
    }

    // Build a max-heap from the array
    private void buildMaxHeap() {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // Maintain the max-heap property for a subtree rooted at index i
    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    // Swap elements at indices i and j
    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the HeapSorter class
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);

        HeapSorter sorter = new HeapSorter(arr);
        sorter.sort();

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
