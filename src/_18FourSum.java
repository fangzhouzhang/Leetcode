import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18FourSum {
	private List<Integer> tmp = new ArrayList<>();
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		for (int i = 0; i < 4; i++) tmp.add(0);
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) continue;
			tmp.set(0, nums[i]);
			threeSum(res, i + 1, target - nums[i], nums);
		}
		return res;
	}

	private void threeSum(List<List<Integer>> res, int start, int target, int[] nums) {
		for (int i = start; i < nums.length - 2; i++) {
			if (i > start && nums[i - 1] == nums[i]) continue;
			tmp.set(1, nums[i]);
			twoSum(res, i + 1, target - nums[i], nums);
		}
	}

	private void twoSum(List<List<Integer>> res, int start, int target, int[] nums) {
		int left = start, right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				tmp.set(2, nums[left]);
				tmp.set(3, nums[right]);
				res.add(new ArrayList<>(tmp));
				left++;
				right--;
				while (left < right && nums[left - 1] == nums[left]) left++;
				while (left < right && nums[right + 1] == nums[right]) right--;
			} else if (nums[left] + nums[right] < target) left++;
			else right--;
		}
	}
}
