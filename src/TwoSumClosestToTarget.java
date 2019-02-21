import java.util.Arrays;

public class TwoSumClosestToTarget {
	public int twoSumClosest(int[] nums, int target) {
		// write your code here
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				return 0;
			} else if (nums[start] + nums[end] < target) {
				diff = Math.min(Math.abs(target - (nums[start] + nums[end])), diff);
				start++;
			} else {
				diff = Math.min(Math.abs(target - (nums[start] + nums[end])), diff);
				end--;
			}
		}
		return diff;
	}
}
