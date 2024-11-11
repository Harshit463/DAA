class Solution {
public:
    bool isMatch(string s, string p) {
        int n = s.length();
        int m = p.length();
        int i=0, j=0, asterik=-1, match;

        while (i < n) {
            if (j < m && p[j] == '*') {
                match = i;
                asterik = j++;
            }
            else if (j < m && (s[i] == p[j] || p[j] == '?')) {
                i++;
                j++;
            }
            else if (asterik >= 0) {
                i = ++match;
                j = asterik + 1;
            }
            else {
                return false;
            }
        }

        while (j < m && p[j] == '*') {
            j++;
        }

        return j == m;
    }
};