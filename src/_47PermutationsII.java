import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _47PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		dfs(nums, 0, res);
		return res;
	}

	private void dfs(int[] nums, int start, List<List<Integer>> res) {
		if (start == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int n : nums) list.add(n);
			res.add(list);
			return;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
				swap(nums, i, start);
				dfs(nums, start + 1, res);
				swap(nums, i, start);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
