public class _747LargestNumberAtLeastTwiceofOthers {
	public int dominantIndex(int[] nums) {
		int maxVal = -1, maxIdx = -1;
		for (int i = 0; i < nums.length; i++) {
			if (maxVal < nums[i]) {
				maxVal = nums[i];
				maxIdx = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (maxIdx != i && maxVal < 2 * nums[i]) {
				return -1;
			}
		}
		return maxIdx;
	}
}
