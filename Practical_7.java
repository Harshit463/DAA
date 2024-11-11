import java.util.Scanner;

public class MakingChange {
    public static void main(String[] args) {
        int[] denominations = {50, 20, 10, 5, 2, 1};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();
        System.out.println("Coins used:");

        for (int coin : denominations) {
            int count = amount / coin;
            if (count > 0) {
                System.out.println(coin + " x " + count);
            }
            amount %= coin;
        }
        scanner.close();
    }
}
