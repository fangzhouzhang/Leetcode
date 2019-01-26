public class BurstBalloons {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Integer[][] mem = new Integer[nums.length][nums.length];
		return dfs(nums, mem, 0, nums.length - 1);
	}
	private int dfs(int[] nums, Integer[][] mem, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (mem[start][end] != null) {
			return mem[start][end];
		}

		//mem[start][end] == null
		int temp = -1;
		for (int i = start; i<= end; i++) {
			int left = dfs(nums, mem, start, i - 1);
			int right = dfs(nums, mem, i + 1, end);
			// isHit[i] = true;
			int leftScore = start - 1 < 0 ? 1 : nums[start - 1];
			int rightScore = end + 1 >= nums.length ? 1 : nums[end + 1];
			int curScore = leftScore * nums[i] * rightScore + left + right;
			temp = Math.max(temp, curScore);
			// isHit[i] = false;
		}
		mem[start][end] = temp;
		return temp;
	}
}
