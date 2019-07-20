public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums.length == 0) {
			return false;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
				start++;
				end--;

			}
			else if (nums[start] <= nums[mid]) {
				//first half is in order
				if (nums[start] <= target && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				//second half is in order
				if (nums[mid] < target && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return false;
	}
}
