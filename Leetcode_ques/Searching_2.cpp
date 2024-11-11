class Solution {
public:
    int firstOcc(vector<int> &nums, int target) {
        int n = nums.size();
        int start = 0;
        int end = n - 1;
        int mid;
        int ans = -1;
        while (start <= end) {
            mid = start + (end - start)/2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    } 

    int lastOcc(vector<int> &nums, int target) {
        int n = nums.size();
        int start = 0;
        int end = n - 1;
        int mid;
        int ans = -1;
        while (start <= end) {
            mid = start + (end - start)/2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    } 

    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> arr(2, -1);
        arr[0] = firstOcc(nums, target);
        arr[1] = lastOcc(nums, target);
        return arr;
    }
};