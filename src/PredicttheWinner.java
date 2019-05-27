public class PredicttheWinner {
	public boolean PredictTheWinner(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return true;
		}
		Integer[][] mem = new Integer[nums.length][nums.length];
		dfs(nums, 0, nums.length - 1, mem);
		return mem[0][nums.length - 1] >= 0 ? true : false;
	}
	private int dfs(int[] nums, int i, int j, Integer[][] mem) {
		if (i == j) {
			return nums[i];
		}

		if (mem[i][j] != null) {
			return mem[i][j];
		}

		int max = -1;

		int val1 = nums[i] - dfs(nums, i + 1, j, mem);
		int val2 = nums[j] - dfs(nums, i, j - 1, mem);

		max = Math.max(val1, val2);
		mem[i][j] = max;
		return max;
	}
}
