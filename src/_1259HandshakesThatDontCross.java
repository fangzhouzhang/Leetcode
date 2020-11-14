public class _1259HandshakesThatDontCross {
	private int M = 1000000007;
	public int numberOfWays(int num_people) {
		long[] dp = new long[num_people + 1];
		if (num_people == 2) return 1;
		if (num_people == 4) return 2;
		dp[2] = 1;
		dp[4] = 2;
		for (int i = 6; i <= num_people; i += 2) {
			long sum = (dp[i - 2] * 2) % M;
			for (int j = 2; j <= num_people && i - 2 - j >= 0; j += 2) {
				sum = (sum + dp[j] * dp[i - 2 - j]) % M;
			}
			dp[i] = sum;
		}
		return (int)dp[num_people];
	}
}
