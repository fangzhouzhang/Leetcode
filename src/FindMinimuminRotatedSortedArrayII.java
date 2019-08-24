public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] nums) {
		for (int num : nums) {
			if (num < nums[0]) {
				return num;
			}
		}
		return nums[0];
	}
}
