public class _837New21Game {
	public double new21Game(int N, int K, int W) {
		double[] dp = new double[N + 1];
		dp[0] = 1;
		double sum = 0;
		for (int i = 1; i <= N; i++) {
			if (i - W - 1 >= 0) sum -= dp[i - W - 1];
			if (i - 1 < K) sum += dp[i - 1];
			dp[i] = sum * 1 / W;
		}
		double res = 0;
		for (int i = K; i <= N; i++) res += dp[i];
		return res;
	}
}
