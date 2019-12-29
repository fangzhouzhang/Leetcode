public class _416PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		int sum = 0;
		for (int n : nums) sum += n;
		if (sum % 2 == 1) return false;
		Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
		return dfs(nums, 0, dp, sum / 2);
	}

	private boolean dfs(int[] nums, int idx, Boolean[][] dp, int sum) {
		if (sum == 0) return true;
		if (idx == nums.length || sum < 0) return false;
		if (dp[idx][sum] != null) return dp[idx][sum];
		for (int i = idx; i < nums.length; i++) {
			if (dfs(nums, i + 1, dp, sum - nums[i])) {
				dp[idx][sum] = true;
				return true;
			}
		}
		dp[idx][sum] = false;
		return false;
	}
}
