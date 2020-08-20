public class _1283FindtheSmallestDivisorGivenaThreshold {
	public int smallestDivisor(int[] nums, int threshold) {
		if (nums == null || nums.length == 0) return 0;
		int start = 1;
		int end = (int)1e6;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isValid(nums, threshold, mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	private boolean isValid(int[] nums, int threshold, int divisor) {
		int end = 0;
		for (int num : nums) {
			if (num % divisor == 0) {
				end += num / divisor;
			} else {
				end += (num / divisor) + 1;
			}
		}
		return end <= threshold;
	}
}
