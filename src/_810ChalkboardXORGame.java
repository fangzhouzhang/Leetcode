public class _810ChalkboardXORGame {
	public boolean xorGame(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) res ^= nums[i];
		if (res == 0 || (nums.length % 2 == 0)) return true;
		return false;
	}
}
