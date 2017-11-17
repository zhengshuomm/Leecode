import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.
Understand the problem:
The problem can be easily solved by count the frequency of each character using a hash map. The only thing need to take special care is consider the length of the string to be even or odd. 
  -- If the length is even. Each character should appear exactly times of 2, e.g. 2, 4, 6, etc..
  -- If the length is odd. One and only one character could appear odd times. */
public class Palindrome_Permutation_266 {
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
         
        Map<Character, Integer> map = new HashMap<Character, Integer>();
         
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
             
            if (map.containsKey(letter)) {
                int count = map.get(letter) + 1;
                map.put(letter, count);
            } else {
                map.put(letter, 1);
            }
        }
         
        int tolerance = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
             
            if ((int) pair.getValue() % 2 != 0) {
                tolerance++;
            }
        }
         
        if (s.length() % 2 == 0) {
            return tolerance == 0;
        } else {
            return tolerance == 1;
        }
    }
}
