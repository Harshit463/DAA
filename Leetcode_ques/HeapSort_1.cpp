#include<bits/stdc++.h>

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int n = nums.size();
        sort(nums.begin(), nums.end());

        int i = 0;

        while (i < n-k) {
            i++;
        }

        return nums[i];
    }
};