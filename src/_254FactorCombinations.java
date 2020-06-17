import java.util.ArrayList;
import java.util.List;

public class _254FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (n <= 1) return res;
		List<Integer> factors = new ArrayList<>();
		getFactors(n, factors);
		dfs(n, 0, res, new ArrayList<Integer>(), factors);
		return res;
	}

	private void dfs(int n, int idx, List<List<Integer>> res, List<Integer> tmp, List<Integer> factors) {
		if (n == 1) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		if (idx == factors.size()) return;
		int num = factors.get(idx);
		for (int i = 0, cur = 1; cur <= n; cur *= num, i++) {
			if ((n % cur) == 0) {
				for (int k = 0; k < i; k++) tmp.add(num);
				dfs(n / cur, idx + 1, res, tmp, factors);
				for (int k = 0; k < i; k++) tmp.remove(tmp.size() - 1);
			}
		}
	}

	private void getFactors(int n, List<Integer> factors) {
		for (int i = 2; i < n; i++) {
			if ((n % i) == 0) {
				factors.add(i);
			}
		}
	}
}
