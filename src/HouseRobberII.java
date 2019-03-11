import java.util.Arrays;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		int v1 = dfs(nums, 0, -10, dp, nums.length - 1);
		Arrays.fill(dp, -1);
		int v2 = dfs(nums, 1, -10, dp, nums.length);
		return Math.max(v1, v2);
	}
	private int dfs(int[] nums, int idx, int prev, int[] dp, int size) {
		if (idx == size) {
			return 0;
		}
		if (dp[idx] != -1) {
			return dp[idx];
		}
		int max = Integer.MIN_VALUE;
		for (int i = idx; i < size; i++) {
			int local = 0;
			if (i - prev == 1) {
				local = dfs(nums, i + 1, i, dp, size);
			} else {
				local = dfs(nums, i + 1, i, dp, size) + nums[i];
			}
			max = Math.max(max, local);
		}
		dp[idx] = max;
		return max;
	}
}
