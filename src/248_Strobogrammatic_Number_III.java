/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,

Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.*/
public class Strobogrammatic_Number_III_248 {
//	¸´ÖÆ´úÂë
//	 1 class Solution {
//	 2 public:
//	 3     Solution() {
//	 4         mp = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
//	 5     }
//	 6     
//	 7     int strobogrammaticInRange(string low, string high) {
//	 8         int ans = 0, l = low.length(), u = high.length();
//	 9         for (int i = l; i <= u; i++) {
//	10             string temp(i, ' ');
//	11             strobogrammaticCount(temp, ans, low, high, 0, i - 1);
//	12         }
//	13         return ans;
//	14     }
//	15 private:
//	16     unordered_map<char, char> mp;
//	17     void strobogrammaticCount(string temp, int& ans, string& low, string& high, int lo, int hi) {
//	18         if (lo > hi) {
//	19             if ((temp[0] != '0' || temp.length() == 1) && less(low, temp) && less(temp, high))
//	20                 ans++;
//	21             return;
//	22         }
//	23         for (auto m : mp) {
//	24             temp[lo] = m.first;
//	25             temp[hi] = m.second;
//	26             if ((lo == hi && m.first == m.second) || lo < hi)
//	27                 strobogrammaticCount(temp, ans, low, high, lo + 1, hi - 1);
//	28         }
//	29     }
//	30     bool less(string& s, string& t) {
//	31         int m = s.length(), n = t.length(), i;
//	32         if (m != n) return m < n;
//	33         for (i = 0; i < m; i++)
//	34             if (s[i] == t[i]) continue;
//	35             else break;
//	36         return i == m || s[i] < t[i];
//	37     }
//	38 };
}
