/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.*/
public class Strobogrammatic_Number_246 {
	 /*1 class Solution {
		 2 public:
		 3     bool isStrobogrammatic(string num) {
		 4         make_lut();
		 5         int n = num.length(); 
		 6         for (int l = 0, r = n - 1; l <= r; l++, r--)
		 7             if (lut.find(num[l]) == lut.end() || lut[num[l]] != num[r])
		 8                 return false;
		 9         return true;
		10     }
		11 private:
		12     unordered_map<char, char> lut; 
		13     void make_lut(void) {
		14         lut['0'] = '0';
		15         lut['1'] = '1';
		16         lut['6'] = '9';
		17         lut['8'] = '8';
		18         lut['9'] = '6';
		19     }
		20 };
*/}
