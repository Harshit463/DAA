class Solution {
public:
    vector<int> nextSmaller(vector<int> arr, int n) {
        stack<int> s;
        s.push(-1);
        vector<int> ans(n);

        for (int i=n-1; i>=0; i--) {
            int curr = arr[i];

            while (s.top() != -1 && arr[s.top()] >= curr) {
                s.pop();
            }

            ans[i] = s.top();
            s.push(i);
        }

        return ans;
    }

    vector<int> prevSmaller(vector<int> arr, int n) {
        stack<int> s;
        s.push(-1);
        vector<int> ans(n);

        for (int i=0; i<n; i++) {
            int curr = arr[i];

            while (s.top() != -1 && arr[s.top()] >= curr) {
                s.pop();
            }

            ans[i] = s.top();
            s.push(i);
        }

        return ans;
    }

    int largestRectangle(vector<int>& height) {
        int n = height.size();

        vector<int> next(n);
        next = nextSmaller(height, n);

        vector<int> prev(n);
        prev = prevSmaller(height, n);

        int area = INT_MIN;

        for (int i=0; i<n; i++) {
            int l = height[i];

            if (next[i] == -1) {
                next[i] = n;
            }

            int b = next[i] - prev[i] - 1;

            int newArea = l*b;

            area = max(area, newArea);
        }

        return area;
    }

    int maximalRectangle(vector<vector<char>>& matrix) {
        int maxi = INT_MIN;
        vector<int> height(matrix[0].size(), 0);

        for (int i=0; i<matrix.size(); i++) {
            for (int j=0; j<height.size(); j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                }
                else {
                    height[j] = 0;
                }
            }

            maxi = max(maxi, largestRectangle(height));
        }

        return maxi;
    }
};