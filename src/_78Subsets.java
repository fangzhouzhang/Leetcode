import java.util.ArrayList;
import java.util.List;

public class _78Subsets {
    /**time o(2^n) space o(n)
     * @param nums: A set of numbers
     * @return: A list of lists
     */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
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

		dfs(nums, idx + 1, res, tmp);
	}
}
