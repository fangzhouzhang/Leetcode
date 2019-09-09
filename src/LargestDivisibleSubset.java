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

	/**
	 * ref to solution of leetcode 368
	 * @param nums
	 * @return
	 */
	public List<Integer> largestDivisibleSubset1(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		List<List<Integer>> eds = new ArrayList<>();
		for (int num : nums) {
			eds.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < nums.length; i++) {
			List<Integer> maxSubset = new ArrayList<>();
			for (int k = 0; k < i; k++) {
				if (nums[i] % nums[k] == 0 && maxSubset.size() < eds.get(k).size()) {
					maxSubset = eds.get(k);
				}
			}
			eds.get(i).addAll(maxSubset);
			eds.get(i).add(nums[i]);
		}
		for (List<Integer> sub : eds) {
			if (res.size() < sub.size()) {
				res = sub;
			}
		}
		return res;
	}
}
