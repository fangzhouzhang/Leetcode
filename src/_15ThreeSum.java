import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length <= 2) return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i  - 1]) continue;
			twoSum(nums, i + 1, 0 - nums[i], res);
		}
		return res;
	}

	private void twoSum(int[] nums, int idx, int target, List<List<Integer>> res) {
		int i = idx, j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] == target) {
				addRes(res, nums, idx - 1, i, j);
				i++;
				j--;
				while (i < j && nums[i - 1] == nums[i]) i++;
				while (i < j && nums[j + 1] == nums[j]) j--;
			} else if (nums[i] + nums[j] < target) i++;
			else j--;
		}
	}

	private void addRes(List<List<Integer>> res, int[] nums, int i, int j, int k) {
		List<Integer> tmp = new ArrayList<>();
		tmp.add(nums[i]);
		tmp.add(nums[j]);
		tmp.add(nums[k]);
		res.add(tmp);
	}
}
