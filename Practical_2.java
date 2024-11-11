import java.util.Scanner;
class SelectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10000];
        System.out.println("Random");
        for (int i = 0; i < num.length; i++) {
            //num[i]=(int)(Math.random()*1000);
            num[i] = i;
            //num[i]=10000-i;

        }
        System.out.println("Array before using Selection sort");
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i] + "");
        }
        long startTime = System.currentTimeMillis();

        System.out.println();
        System.out.println("Before Selection Sort");
        for (int i: num) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < num.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[index]) {
                    index = j;
                }
            }
            int small = num[index];
            num[index] = num[i];
            num[i] = small;
        }
        System.out.println("After Selection Sort");
        for (int i: num) {
            System.out.print(i + " ");

        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("\nThis is duration " + duration);

    }
}
