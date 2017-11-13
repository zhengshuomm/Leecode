import java.util.ArrayList;
import java.util.List;

//Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
public class Encode_and_Decode_Strings_271 {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
         
        StringBuffer sb = new StringBuffer();
         
        for (String str : strs) {
            int len = str == null ? 0 : str.length();
            sb.append(len);
            sb.append('#');
            sb.append(str);
        }
         
        return sb.toString();
    }
 
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
         
        int i = 0;
        while (i < s.length()) {
            int len = 0;
            // Get length
            while (i < s.length() && s.charAt(i) != '#') {
                len = len * 10 + Character.getNumericValue(s.charAt(i));
                i++;
            }
             
            String str = s.substring(i + 1, i + len + 1);
            result.add(str);
            i = i + len + 1;
        }
         
        return result;
    }
}
