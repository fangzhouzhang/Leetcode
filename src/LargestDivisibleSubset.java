import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	/**
	 * @param nums: a set of distinct positive integers
	 * @return: the largest subset
	 * ref: https://blog.csdn.net/qq508618087/article/details/51767785
	 * time: o(n^2) space: o(n)
	 */
	public List<Integer> largestDivisibleSubset(int[] nums) {
		// write your code here
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		int[] dp = new int[nums.length];//dp[i] means including nums[i], largest number of divisible subset elements
		int maxIdx = 0;
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			if (max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		System.out.println(max);
		int temp = nums[maxIdx];
		for (int i = maxIdx; i >= 0; i--) {
			if (temp % nums[i] == 0 && max == dp[i]) {
				res.add(nums[i]);
				temp = nums[i];
				max--;
			}
		}
		return res;
	}
}
