
public class Regular_Expression {
	public static void main(String[] args) {
		System.out.println(isMatch("aaa", "aaa+"));
//		System.out.println(regMatch("aaa", "aa+"));
	}

	public static boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < dp[0].length; i++) {
			if (p.charAt(i - 1) == '*')
				dp[0][i] = dp[0][i - 2];
			else
				dp[0][i] = false;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2];
					if (p.charAt(j - 2) == '.' || (p.charAt(j - 2) == s.charAt(i - 1))) {
						dp[i][j] |= dp[i - 1][j];
					}
				} else if (p.charAt(j - 1) == '+') {
//					dp[i][j] = dp[i][j - 1];
					if (p.charAt(j - 2) == '.' || (p.charAt(j - 2) == s.charAt(i - 1))) {
						dp[i][j] |= dp[i - 1][j];
					}
				} else {
					dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1));
				}
			}
		}
		return dp[s.length()][p.length()];
	}

}
