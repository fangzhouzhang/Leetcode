import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			twoSum(res, 0 - nums[i], i + 1, nums);
		}
		return res;
	}
	private void twoSum(List<List<Integer>> res,
						int t,
						int start,
						int[] nums) {

		int s = start;
		int e = nums.length - 1;
		while (s < e) {
			if (nums[s] + nums[e] == t) {
				addRes(res, 0 - t, nums[s], nums[e]);
				s++;e--;
				while (s < e && nums[s] == nums[s - 1]) {
					s++;
				}
				while (s < e && nums[e] == nums[e + 1]) {
					e--;
				}
			} else if (nums[s] + nums[e] < t) {
				s++;
			} else {
				e--;
			}
		}
	}


	private void addRes(List<List<Integer>> res,
						int n1,
						int n2,
						int n3) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		res.add(list);

	}
}
