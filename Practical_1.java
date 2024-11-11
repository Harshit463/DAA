class BubbleSort {
    static void bubblesort(int arr[]) {
        int n = arr.length;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (arr[j - 1] > arr[j])
                //Swap the element as bigger element is found before the word searched
                {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    public static void main(String args[]) {
        int[] inputTenThousand = new int[10000];
        for (int a = 0; a < inputTenThousand.length; a++) {
            inputTenThousand[a] = (a % 10000) + 1;
        }

        long startTime = System.currentTimeMillis();
        System.out.println("Array before using Bubble sort");
        for (int i = 0; i < inputTenThousand.length; i++) {
            System.out.println(inputTenThousand[i] + "");
        }
        System.out.println();
        bubblesort(inputTenThousand);
        System.out.println("Array after using Bubble sort");
        for (int i = 0; i < inputTenThousand.length; i++) {
            System.out.println(inputTenThousand[i] + "");

        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("\n This is duration " + duration);
    }
}
