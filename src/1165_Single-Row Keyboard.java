//Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
//Output: 4
//Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
//Total time = 2 + 1 + 1 = 4. 
class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] index = new int[26];
        for (int i = 0 ;  i < keyboard.length() ; i ++) {
            char c = keyboard.charAt(i);
            index[c - 'a'] = i;
        }
        
        // System.out.println(Arrays.toString(index));
        int sum = 0;
        int prev = 0;
        for (int i = 0 ; i < word.length() ; i ++) {
            char c = word.charAt(i);
            int cur = index[c - 'a'];
            // System.out.println(cur - prev);
            sum += Math.abs(cur - prev);
            prev = cur;
        }
        return sum;
    }
}