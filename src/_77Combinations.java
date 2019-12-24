import java.util.ArrayList;
import java.util.List;

public class _77Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     * time : o(2^n)
     * space: call stack o(h)
     *          arr o(n)
     */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, n, k, 1, new ArrayList<Integer>());
		return res;
	}

	private void dfs(List<List<Integer>> res, int n, int k, int num, List<Integer> tmp) {
		if (0 == k) {
			res.add(new ArrayList<>(tmp));
			return;
		}

		for (int i = num; i <= n - k + 1; i++) {
			tmp.add(i);
			dfs(res, n, k - 1, i + 1, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
