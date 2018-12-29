import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
	/**
	 * @param n: a integer
	 * @return: return a 2D array
	 * time: o(x^n) x is number of log min_factor Integer
	 * space: call stack o(h) factors o(n)
	 */
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n <= 1) {
			return res;
		}
		List<Integer> factors = findFactors(n);
		dfs(res, new ArrayList<Integer>(), factors, 0, 1, n);
		return res;
	}
	private List<Integer> findFactors(int n) {
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
	private void dfs(List<List<Integer>> res,
					 List<Integer> temp,
					 List<Integer> factors,
					 int level,
					 int product,
					 int n) {
		if (product == n) {
			res.add(new ArrayList<>(temp));
			return;
		}
		if (level >= factors.size()) {
			return;
		}

		int factor = factors.get(level);

		for (int i = 0; product <= n; product *= factor, i++) {
			addFactor(temp, factor, i);
			dfs(res, temp, factors, level + 1, product, n);
			remFactor(temp, i);
		}
	}
	private void addFactor(List<Integer> temp,
						   int factor,
						   int num) {
		for (int i = 0; i < num; i++) {
			temp.add(factor);
		}
	}
	private void remFactor(List<Integer> temp,
						   int num) {
		for (int i = 0; i < num; i++) {
			temp.remove(temp.size() - 1);
		}
	}
}
