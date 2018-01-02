import java.util.HashMap;
import java.util.Map;

public class Collatz_Conjecture {
	
	public static void main(String[] strs) {
		Collatz_Conjecture c = new Collatz_Conjecture();
		System.out.println(c.findLongestSteps(2));
	}
	
	Map<Integer, Integer> map = new HashMap<>();

	private int findSteps(int num) {
		if (num <= 1)
			return 1;
		if (map.containsKey(num))
			return map.get(num);
		if (num % 2 == 0)
			return 1 + findSteps(num / 2);
		return 1 + findSteps(3 * num + 1);
	}

	public int findLongestSteps(int num) {
		if (num < 1)
			return 0;
		int res = 0;
		for (int i = 1; i <= num; i++) {
			int t = findSteps(i);
			map.put(i, t);
			res = Math.max(res, t);
		}
		return res;
	}
	
  // 1
  // 2 -> 1
  // 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
  // 4 -> 2 -> 1
  // 5 -> 16 -> 8 -> 4 -> 2 -> 1
  // 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
  // 7 -> 22 -> 11 -> 34 -> 17
}
