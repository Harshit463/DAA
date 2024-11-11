class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy = 0;
        int profit = 0;
        int n = prices.size();
        // int sell = n-1;

        for (int i=1; i<n; i++) { 
            if (prices[buy] > prices[i]) {
                buy = i;
            }

            profit = max(profit, prices[i] - prices[buy]);
        }

        return profit;
    }
};