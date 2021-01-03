import java.util.Arrays;

public class _628MaximumProductofThreeNumbers {
	public int maximumProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Arrays.sort(nums);
		int n = nums.length;
		return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
	}
}
