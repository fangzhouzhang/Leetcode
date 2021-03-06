public class WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int prevDiff = nums[1] - nums[0];
		int count = nums[1] - nums[0] != 0 ? 2 : 1;
		for (int i = 2; i < nums.length; i++) {
			int diff = nums[i] - nums[i - 1];
			if ((prevDiff >= 0 && diff < 0) || (prevDiff <= 0 && diff > 0)) {
				count++;
				prevDiff = diff;
			}
		}
		return count;
	}
}
