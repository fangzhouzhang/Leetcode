import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40CombinationSumIII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return res;
		Arrays.sort(candidates);
		dfs(res, new ArrayList<Integer>(), candidates, 0, target);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int idx, int target) {
		if (target == 0) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = idx; i < candidates.length; i++) {
			if (i > idx && candidates[i] == candidates[i - 1]) continue;
			if (target - candidates[i] < 0) break;
			tmp.add(candidates[i]);
			dfs(res, tmp, candidates, i + 1, target - candidates[i]);
			tmp.remove(tmp.size() - 1);
		}
	}
}
