public class SingleElementinaSortedArray {
	public int singleNonDuplicate(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if ((mid ^ 1) < 0 || (mid ^ 1) >= nums.length ) return nums[mid];
			if (nums[mid] == nums[mid ^ 1]) start = mid + 1;
			else end = mid - 1;
		}
		return nums[start];
	}
}
