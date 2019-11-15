public class _162FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length <= 0) return -1;
		return search(nums, 0, nums.length - 1);
	}

	private int search(int[] nums, int start, int end) {
		if (start == end) return start;
		int mid = start + (end - start) / 2;
		if (nums[mid] > nums[mid + 1]) return search(nums, start, mid);
		else return search(nums, mid + 1, end);
	}
}
