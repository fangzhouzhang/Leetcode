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

	private int n = 0;
	private int k = 0;
	public List<List<Integer>> combine1(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (k == 0 || n == 0) return result;
		this.n = n;
		this.k = k;
		List<Integer> tmp = new ArrayList<>();
		dfs1(1, tmp, result);
		return result;
	}

	private void dfs1(int cur, List<Integer> tmp, List<List<Integer>> res) {
		if (tmp.size() == k) {
			res.add(new ArrayList<>(tmp));
			return;
		}

		if (tmp.size() > k || cur == n + 1) return;

		tmp.add(cur);
		dfs1(cur + 1, tmp, res);
		tmp.remove(tmp.size() - 1);

		dfs1(cur + 1, tmp, res);
	}
}
