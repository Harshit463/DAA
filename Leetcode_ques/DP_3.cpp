class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int left=0;
        int right=n-1;
        int leftMax=0, rightMax=0;
        int ans=0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                else {
                    ans += leftMax - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }
                else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }

        return ans;
    }
};