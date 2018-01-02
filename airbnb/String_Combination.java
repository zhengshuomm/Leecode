import java.util.ArrayList;
import java.util.List;

public class String_Combination {
	private boolean isBitSet(int n, int offset) {
		return (n >> offset & 1) != 0;
	}

	public List<String> ermutateString(String text) {
		List<String> res = new ArrayList<>();
		if (text == null || text.length() == 0) {
			return res;
		}
		char[] chars = text.toCharArray();
		for (int i = 0, n = (int) Math.pow(2, chars.length); i < n; i++) {
			char[] curr = new char[chars.length];
			for (int j = 0; j < chars.length; j++) {
				curr[j] = (isBitSet(i, j)) ? Character.toUpperCase(chars[j]) : chars[j];
			}
			res.add(new String(curr));
		}
		return res;
	}
}
