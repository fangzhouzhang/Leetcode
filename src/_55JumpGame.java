public class _55JumpGame {
	/**
	 * @param nums: A list of integers
	 * @return: A boolean
	 */
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		boolean[] dp = new boolean[nums.length];
		dp[nums.length - 1] = true;
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int step = nums[i]; step >= 1; step--) {
				if (i + step >= nums.length - 1 || (i + step < nums.length && dp[i + step])) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[0];
	}
}
