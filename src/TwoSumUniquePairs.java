import java.util.Arrays;

public class TwoSumUniquePairs {
	public int twoSum6(int[] nums, int target) {
		// write your code here
		Arrays.sort(nums);
		int res = 0;
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				res++;
				start++;
				end--;
				while (start < end && nums[start] == nums[start - 1]) {
					start++;
				}
				while (start < end && nums[end] == nums[end + 1]) {
					end--;
				}
			} else if (nums[start] + nums[end] < target) {

				start++;
			} else {

				end--;
			}
		}
		return res;
	}
}
