import java.util.Arrays;

public class HouseRobber {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		return dfs(nums, dp, 0, -10);
	}
	private int dfs(int[] nums, int[] res, int idx, int prev) {
		if (idx == nums.length) {
			return 0;
		}
		if (res[idx] != -1) {
			return res[idx];
		}
		int max = Integer.MIN_VALUE;
		for (int i = idx; i < nums.length; i++) {
			int local = 0;
			if (i - prev == 1) {
				local = dfs(nums, res, i + 1, i);
			} else {
				local = dfs(nums, res, i + 1, i) + nums[i];
			}
			max = Math.max(max, local);
		}
		res[idx] = max;
		return max;
	}
}
