import java.util.Arrays;

public class _1477FindTwoNonoverlappingSubarraysEachWithTargetSum {
	public int minSumOfLengths(int[] arr, int target) {
		int n = arr.length;
		int res = Integer.MAX_VALUE, sum = 0;
		int[] dp = new int[n];
		Arrays.fill(dp, 100000000);
		for (int fast = 0, slow = 0; fast < n; fast++) {
			sum += arr[fast];
			while (sum > target) {
				sum -= arr[slow++];
			}
			if (sum == target) {
				if (slow > 0) res = Math.min(res, fast - slow + 1 + dp[slow - 1]);
				dp[fast] = fast - slow + 1;
			}
			if (fast > 0) dp[fast] = Math.min(dp[fast - 1], dp[fast]);
		}
		return res > n ? -1 : res;
	}
}
