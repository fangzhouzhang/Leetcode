public class _287FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int start = 1, end = nums.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int small = 0, equal = 0;
			for (int n : nums) {
				if (n < mid) small++;
				if (n == mid) equal++;
			}
			if (equal > 1) return mid;
			if (small > mid - 1) end = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}
}
