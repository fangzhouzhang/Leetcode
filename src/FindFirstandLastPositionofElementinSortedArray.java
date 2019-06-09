public class FindFirstandLastPositionofElementinSortedArray {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[]{-1, -1};
		}
		int[] res = new int[]{-1, -1};
		int l = findFirst(nums, res, target);
		if (l == nums.length || nums[l] != target) {return res;}
		int r = findLast(nums, res, target);
		res[0] = l;
		res[1] = r;
		return res;
	}
	private int findFirst(int[] nums, int[] res, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] >= target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
	private int findLast(int[] nums, int[] res, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] <= target) {

				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return r;
	}
}
