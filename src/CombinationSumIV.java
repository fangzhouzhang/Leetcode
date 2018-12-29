import java.util.Arrays;

public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);


		Integer[] dp = new Integer[target + 1];
		for (int i = 0; i < nums.length; i++) {
			if (!isValid(dp, nums[i])) {
				continue;
			}
			if (i == 0) {
				dp[nums[i]] = 1;
			} else {
				dp[nums[i]] = 0;
				for (int j = 0; j < i; j++) {
					if (dp[nums[i] - nums[j]] != null) {
						dp[nums[i]] += dp[nums[i] - nums[j]];
					} else {
						dp[nums[i]] += mem(dp, nums, nums[i] - nums[j]);
					}
				}
				dp[nums[i]] += 1;
			}
		}

		for (int i = 0; i < nums[0]; i++) {
			if (!isValid(dp, i)) {
				continue;
			}
			dp[i] = 0;
		}
		for (int i = nums[0] + 1; i < dp.length; i++) {
			if (dp[i] != null) {
				continue;
			}
			dp[i] = 0;
			for (int j = 0; j < nums.length && i - nums[j] > 0; j++) {
				if (dp[i - nums[j]] != null) {
					dp[i] += dp[i - nums[j]];
				} else {
					dp[i] += mem(dp, nums, i - nums[j]);
				}
			}
		}



		return dp[target];
	}
	private int mem(Integer[] dp, int[] nums, int idx) {
		dp[idx] = 0;
		for (int i = 0; i < nums.length && idx - nums[i] > 0; i++) {
			if (dp[idx - nums[i]] != null) {
				dp[idx] += dp[idx - nums[i]];
			} else {
				dp[idx] += mem(dp, nums, idx - nums[i]);
			}
		}
		return dp[idx];
	}
	private boolean isValid(Integer[] dp, int i) {
		if (i < 0 || i >= dp.length) {
			return false;
		}
		return true;
	}
}
