import java.util.*;

public class _39CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     * time:o(target / min_candidate ^ candidates.length)
     * space : o(n)
     */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return res;
		dfs(res, candidates, 0, target, new ArrayList<Integer>());
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] candidates, int idx, int target, List<Integer> tmp) {
		if (idx == candidates.length && target == 0) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		if (idx == candidates.length) return;

		for (int i = 0; target - candidates[idx] * i >= 0; i++) {
			for (int j = 0; j < i; j++) tmp.add(candidates[idx]);
			dfs(res, candidates, idx + 1, target - candidates[idx] * i, tmp);
			for (int j = 0; j < i; j++) tmp.remove(tmp.size() - 1);
		}
	}
}
