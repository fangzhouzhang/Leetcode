public class BurstBalloons {
	public int maxCoins(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[][] dp = new int[nums.length][nums.length];
		dfs(nums, dp, 0, nums.length - 1);
		return dp[0][nums.length - 1];
	}
	private int dfs(int[] nums, int[][] dp, int start, int end) {
		if (start > end) {
			return 0;
		}

		if (dp[start][end] != 0) {
			return dp[start][end];
		}

		int leftVal = start - 1 < 0 ? 1 : nums[start - 1];
		int rightVal = end + 1 >= nums.length ? 1 : nums[end + 1];

		int max = 0;

		for (int i = start; i <= end; i++) {
			max = Math.max(max, dfs(nums, dp, start, i - 1) + leftVal * nums[i] * rightVal + dfs(nums, dp, i + 1, end));
		}
		dp[start][end] = max;
		return dp[start][end];
	}
}
