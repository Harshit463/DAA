import java.util.Arrays;
import java.util.Scanner;

public class MakingChangeDP {
    public static int minCoins(int coins[], int m, int amount) {
        int dp[] = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of different coins: ");
        int m = scanner.nextInt();
        int coins[] = new int[m];

        System.out.println("Enter the values of the coins:");
        for (int i = 0; i < m; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.print("Enter the total amount: ");
        int amount = scanner.nextInt();

        int result = minCoins(coins, m, amount);

        if (result == -1) {
            System.out.println("It is not possible to make the given amount with the provided coins.");
        } else {
            System.out.println("Minimum number of coins needed: " + result);
        }

        scanner.close();
    }
}
