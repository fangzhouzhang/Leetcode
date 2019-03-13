public class LongestTurbulentSubarray {
	public int maxTurbulenceSize(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return 1;
		}
		int[] change = new int[A.length];
		change[0] = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				change[i] = 1;
			} else if (A[i] == A[i - 1]) {
				change[i] = 0;
			} else {
				change[i] = -1;
			}
		}
		int[] dp = new int[A.length];
		dp[0] = 0;
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			if (change[i] == 0) {
				dp[i] = 0;
			} else if (change[i] == (change[i - 1] * -1)) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = 1;
			}
			max = Math.max(max, dp[i]);
		}
		return max + 1;
	}
}
