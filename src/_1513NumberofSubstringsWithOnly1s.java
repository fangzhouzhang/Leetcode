public class _1513NumberofSubstringsWithOnly1s {
	int M = 1000000007;
	public int numSub(String s) {
		if (s == null || s.length() == 0) return 0;
		if (s.length() == 1) return s.charAt(0) == '1' ? 1 : 0;
		int[] dp = new int[s.length()];
		dp[0] = s.charAt(0) == '1' ? 1 : 0;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '1') {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = 0;
			}
		}
		long res = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (dp[i + 1] == 0) {
				res = (res + ((long)dp[i] + 1) * (long)dp[i] / 2) % M ;
			}
		}
		if (dp[s.length() - 1] == dp[s.length() - 2] + 1) {
			res = (res + ((long)dp[s.length() - 1] + 1) * (long)dp[s.length() - 1] / 2) % M;
		}
		return (int)res;
	}
}
