class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        int start=0, end=0, maxl=1;
        
            for (int i=0; i<n; i++) {
                int l=i, r=i;
                
                while (l>=0 && r<n) {
                    if (s[l] != s[r]) {
                        break;
                    }
                    
                    l--;
                    r++;
                }
                int len = r-l-1;
                if (len > maxl) {
                    maxl = len;
                    start = l + 1;
                    end = r - 1;
                }
            }
        
            for (int i=0; i<n; i++) {
                int l=i, r=i+1;
                
                while (l>=0 && r<n) {
                    if (s[l] != s[r]) {
                        break;
                    }
                    
                    l--;
                    r++;
                }
                int len = r-l-1;
                if (len > maxl) {
                    maxl = len;
                    start = l + 1;
                    end = r - 1;
                }
            }
        
        return s.substr(start, maxl);
    }
};