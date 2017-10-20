import java.util.HashSet;
import java.util.Set;

public class PadlindromSubsequce {

	public static void main(String[] args) {
		Set<String> result = new HashSet<>();
		char[] input = { '1', '2', '3', '4', '3', '2', '1' };
		DFS(result, "", 0, input.length - 1, input);
		System.out.println(result);
	}

	public static void DFS(Set<String> result, String sb, int start, int end, char[] input) {
		if (sb.length() >= 0) {
			if (sb.length() > 0)
				result.add(sb);
			int length = sb.length() / 2;
			for (int i = start; i <= end; i++) {
				result.add(sb.substring(0, length) + input[i] + sb.substring(length));
			}
		}

		for (int j = end; j >= start; j--) {
			for (int i = start; i < j; i++) {
				if (input[i] == input[j]) {
					if (sb.length() > 0) {
						int length = sb.length() / 2;
						DFS(result, sb.substring(0, length) + input[i] + input[j] + sb.substring(length), i + 1, j - 1,
								input);
					} else {
						DFS(result, "" + input[i] + input[j], i + 1, j - 1, input);
					}
				}
			}
		}
	}
}
