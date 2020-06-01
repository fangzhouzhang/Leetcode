import java.util.ArrayList;
import java.util.List;

public class _216CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, new ArrayList<>(), 1, 0, k, n);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> tmp, int cur, int sum, int k, int n) {
		if (tmp.size() == k && sum == n) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		if (tmp.size() > k || sum > n || cur > 9) return;


		tmp.add(cur);
		dfs(res, tmp, cur + 1, sum + cur, k, n);
		tmp.remove(tmp.size() - 1);

		dfs(res, tmp, cur + 1, sum, k, n);
	}
}
