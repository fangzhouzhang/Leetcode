import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
	public int minMoves2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int res = 0;
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			res += nums[end--] - nums[start++];
		}
		return res;
	}
}
