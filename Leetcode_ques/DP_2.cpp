class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.size();
        stack<int> st;
        int i=0;

        while (i < n) {
            if (s[i] == '(') {
                st.push(i);
            }
            else if (s[i] == ')') {
                if (st.empty() || s[st.top()] != '(') {
                    st.push(i);
                }
                else if (s[st.top()] == '(') {
                    st.pop();
                }
            }

            i++;
        }

        int cnt = 0;
        int end = n;

        while (!st.empty()) {
            int l = st.top();
            st.pop();
            cnt = max(cnt, end-l-1);
            end = l;
        }

        cnt = max(cnt, end);

        return cnt;
    }
};