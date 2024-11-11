public class LongestCommonSubsequence {

    // Function to find the length of LCS
    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create a 2D array to store the lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp array bottom-up
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n]; // LCS length is in dp[m][n]
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int lcsLength = lcs(X, Y);
        System.out.println("Length of LCS is " + lcsLength);
    }
}
