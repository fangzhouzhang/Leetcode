import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4) {
			return res;
		}

		Arrays.sort(nums);
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			threeSum(res, nums, target - nums[i], i + 1, temp);
			temp.remove(temp.size() - 1);
		}
		return res;
	}

	private void threeSum(List<List<Integer>>res,
						  int[] nums,
						  int target,
						  int start,
						  List<Integer> temp) {
		for (int i = start; i < nums.length - 2; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			twoSum(res, nums, target - nums[i], i + 1, temp);
			temp.remove(temp.size() - 1);
		}
	}

	private void twoSum(List<List<Integer>>res,
						int[] nums,
						int target,
						int start,
						List<Integer> temp) {
		int s = start;
		int e = nums.length - 1;
		while (s < e) {
			if (nums[s] + nums[e] == target) {
				temp.add(nums[s]);
				temp.add(nums[e]);
				res.add(new ArrayList<>(temp));
				temp.remove(temp.size() - 1);
				temp.remove(temp.size() - 1);

				s++;
				e--;
				while (s < e && nums[s - 1] == nums[s]) {
					s++;
				}
				while (s < e && nums[e] == nums[e + 1]) {
					e--;
				}
			} else if (nums[s] + nums[e] < target) {
				s++;
			} else {
				e--;
			}
		}
	}
}
