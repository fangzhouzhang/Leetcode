import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90SubsetsII {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * time : o(2^n)
     * space: call stack o(h)
     *          heap o(n)
     */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		dfs(nums, 0, res, new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] nums, int idx, List<List<Integer>> res, List<Integer> tmp) {
		if (idx == nums.length) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		tmp.add(nums[idx]);
		dfs(nums, idx + 1, res, tmp);
		tmp.remove(tmp.size() - 1);

		while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) idx++;
		dfs(nums, idx + 1, res, tmp);
	}
}
