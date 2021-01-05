public class _287FindtheDuplicateNumber {
	/**
	 * version 1: [l, mid - 1], [mid, r]
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int l = 1, r = n;
		while (l < r) {
			int mid = l + r + 1 >> 1;
			int count = 0;
			for (int x : nums) {
				if (x >= l && x < mid) count++;
			}

			if (count > mid - l) r = mid - 1;
			else l = mid;
		}
		return l;
	}

	/**
	 * version 2: [l, mid], [mid + 1, r]
	 * @param nums
	 * @return
	 */
	public int findDuplicateI(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int l = 1, r = n;
		while (l < r) {
			int mid = l + r >> 1;
			int count = 0;
			for (int x : nums) {
				if (x >= l && x <= mid) count++;
			}

			if (count > mid - l + 1) r = mid;
			else l = mid + 1;
		}
		return l;
	}
}
