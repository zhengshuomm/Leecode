import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pyramid_Transition {

	public static void main(String[] args) {
		String[] lines = { "A,A,AC", "A,B,CD", "A,C,D", "A,D,B", "B,A,B", "B,B,C", "B,C,A", "B,D,CD", "C,A,A", "C,B,C",
				"C,C,D", "C,D,B", "D,A,BC", "D,B,D", "D,C,A", "D,D,C" };
		Pyramid_Transition pt = new Pyramid_Transition(lines, "CD");
		System.out.println(pt.check("ABCD"));
		System.out.println(pt.check("AACC"));
		System.out.println(pt.check("AAAA"));
	}

	private Set<Character> ruleSet;
	private Map<Character, Map<Character, Set<Character>>> transitionDict;
	private Map<String, Boolean> cache;

	public Pyramid_Transition(String[] lines, String rule) {
		ruleSet = new HashSet<>();
		for (int i = 0; i < rule.length(); i++) {
			ruleSet.add(rule.charAt(i));
		}

		transitionDict = new HashMap<>();
		for (String line : lines) {
			String[] parts = line.split(",");
			char left = parts[0].charAt(0);
			char right = parts[1].charAt(0);

			if (!transitionDict.containsKey(left)) {
				transitionDict.put(left, new HashMap<>());
			}
			transitionDict.get(left).put(right, new HashSet<>());

			for (int i = 0; i < parts[2].length(); i++) {
				transitionDict.get(left).get(right).add(parts[2].charAt(i));
			}
		}

		cache = new HashMap<>();
	}

	public boolean check(String input) {
		if (cache.containsKey(input)) {
			return cache.get(input);
		}

		if (input.length() == 1) {
			cache.put(input, ruleSet.contains(input.charAt(0)));
			return cache.get(input);
		}

		List<String> nextLevel = new ArrayList<>();
		getNextLevel(nextLevel, input, 0, new StringBuilder());

		for (String nextInput : nextLevel) {
			if (check(nextInput)) {
				cache.put(input, true);
				return true;
			}
		}

		cache.put(input, false);
		return false;
	}

	private void getNextLevel(List<String> res, String input, int start, StringBuilder sb) {
		if (start == input.length() - 1) {
			res.add(sb.toString());
			return;
		}

		char left = input.charAt(start);
		char right = input.charAt(start + 1);
		for (char c : transitionDict.get(left).get(right)) {
			sb.append(c);
			getNextLevel(res, input, start + 1, sb);
			sb.setLength(sb.length() - 1);
		}
	}

}
