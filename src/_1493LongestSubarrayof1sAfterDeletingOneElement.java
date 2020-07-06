public class _1493LongestSubarrayof1sAfterDeletingOneElement {
	public int longestSubarray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0, start = 0, end = 0, zero = 0;
		int n = nums.length;
		while (end < n) {
			if (nums[end] == 0) {
				zero++;
			}
			while (zero > 1) {
				if (nums[start] == 0) {
					zero--;
				}
				start++;
			}
			res = Math.max(res, end - start + 1);
			end++;
		}
		return res - 1;
	}
}
