import java.util.Arrays;

public class _611ValidTriangleNumber {
	public int triangleNumber(int[] nums) {
		if (nums == null || nums.length < 3) return 0;
		int n = nums.length, res = 0;
		Arrays.sort(nums);
		for (int k = 2; k < n; k++) {
			for (int j = k - 1, i = 0; j > 0 && j > i; j--) {
				while (i < j && nums[i] + nums[j] <= nums[k]) i++;
				res += j - i;
			}
		}
		return res;
	}
}
