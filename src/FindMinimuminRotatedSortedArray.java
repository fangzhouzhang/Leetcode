public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums[0] >= nums[nums.length - 1]) {
			int left = 0;
			int right = nums.length - 1;
			int mid = 0;
			while (left != right - 1) {
				mid = left + (right - left) / 2;
				if (nums[left] < nums[mid]) {
					left = mid;
				} else {
					right = mid;
				}
			}
			return Math.min(nums[left], nums[right]);
		}
		return nums[0];
	}
}
