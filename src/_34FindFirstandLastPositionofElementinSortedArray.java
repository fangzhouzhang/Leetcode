public class _34FindFirstandLastPositionofElementinSortedArray {
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) return new int[]{-1, -1};
		int[] res = new int[2];
		int first = getFirst(nums, target);
		int last = getLast(nums, target);
		res[0] = first;
		res[1] = last;
		return res;
	}

	private int getFirst(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (target <= nums[mid]) end = mid;
			else start = mid;
		}
		if (nums[start] == target) return start;
		if (nums[end] == target) return end;
		return -1;
	}

	private int getLast(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (target >= nums[mid]) start = mid;
			else end = mid;
		}
		if (nums[end] == target) return end;
		if (nums[start] == target) return start;
		return -1;
	}

	public int[] searchRangeI(int[] nums, int target) {
		if (nums == null || nums.length == 0) return new int[]{-1, -1};
		int n = nums.length;
		int l = 0, r = n - 1;
		while (l < r) {
			int mid = l + r >> 1;
			if (nums[mid] < target) l = mid + 1;
			else r = mid;
		}
		int[] res = {-1, -1};
		if (nums[l] != target) return new int[]{-1, -1};
		res[0] = l;
		r = n - 1;
		while (l < r) {
			int mid = l + r + 1>> 1;
			if (nums[mid] > target) r = mid - 1;
			else l = mid;
		}
		res[1] = r;
		return res;
	}
}
