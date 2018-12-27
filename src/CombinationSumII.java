import java.util.*;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates.length == 0) {
			return res;
		}

		Arrays.sort(candidates);

		dfs(res, new ArrayList<Integer>(), candidates, target, 0, 0, new HashSet<List<Integer>>());
		return res;
	}
	private void dfs(List<List<Integer>> res,
					 List<Integer> temp,
					 int[] candidates,
					 int target,
					 int sum,
					 int level,
					 Set<List<Integer>> set) {
		if (sum != target && level >= candidates.length) {
			return;
		}
		if (sum == target) {
			if (!set.contains(new ArrayList<>(temp))) {
				res.add(new ArrayList<>(temp));
				set.add(new ArrayList<>(temp));
			}
			return;
		}



		for (int i = 0; i <= 1 && target - candidates[level] * i - sum >= 0; i++) {
			addNum(temp, candidates, level, i);
			dfs(res, temp, candidates, target, sum + candidates[level] * i, level + 1, set);
			removeNum(temp, i);
		}
	}
	private void addNum(List<Integer> temp,
						int[] candidates,
						int level,
						int num) {
		for (int i = 0; i < num; i++) {
			temp.add(candidates[level]);
		}
	}
	private void removeNum(List<Integer> temp,
						   int num) {
		for (int i = 0; i < num; i++) {
			temp.remove(temp.size() - 1);
		}
	}
}
