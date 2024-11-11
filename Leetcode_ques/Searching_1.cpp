class Solution {
public:

int getPivot(vector<int>& nums) {    
    int s = 0;
    int e = nums.size()-1;
    int mid;
    while (s < e) {
        mid = s + (e - s)/2;
        if (nums[mid] >= nums[0]) {
            s = mid + 1;
        }
        else {
            e = mid;
        }
    }
    return s;
}

int search(vector<int>& nums, int s, int e, int target) {
    int n = nums.size();
    int start = s;
    int end = e;
    int mid;
    while (start <= end) {
        mid = start + (end - start)/2;
        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] > target) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
    }
    return -1;       
}

int search(vector<int>& nums, int target) {
    int pivot = getPivot(nums);
    if (nums[pivot] <= target && target <= nums[nums.size()-1]) {
        return search(nums, pivot, nums.size()-1, target);
    }       
    else {
        return search(nums, 0, pivot-1, target);
    }
}

};