import java.util.*;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		dfs(res, new ArrayList<Integer>(), candidates, target, 0, 0);
		return res;
	}

	private void dfs(List<List<Integer>> res,
					 List<Integer> temp,
					 int[] candidates,
					 int target,
					 int sum,
					 int level) {
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (sum >= target || level >= candidates.length) {
			return;
		}

		//add element
		temp.add(candidates[level]);
		if (sum + candidates[level] <= target) dfs(res, temp, candidates, target, sum + candidates[level], level + 1);
		temp.remove(temp.size() - 1);

		//not add element
		while (level + 1 < candidates.length && candidates[level + 1] == candidates[level]) level++;
		dfs(res, temp, candidates, target, sum, level + 1);
	}
}
