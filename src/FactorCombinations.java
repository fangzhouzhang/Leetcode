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
		// write your code here
		if (n <= 1) {
			return null;
		}
		List<Integer> factors = new ArrayList<>();
		//get factors of n
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				factors.add(i);
			}
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		getFactor(factors, 0, n, res, new ArrayList<Integer>());
		return res;
	}
	public void getFactor(List<Integer> factors, int level,int remain,
						  List<List<Integer>> res, List<Integer> temp) {
		if (remain == 1){
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		if (level == factors.size()) {
			return;
		}
		int count = 0;
		for (int i = 1; i <= remain; i *= factors.get(level)) {
			if (remain % i == 0) {
				for (int j = 1; j <= count; j++) {
					temp.add(factors.get(level));
				}
				getFactor(factors, level + 1, remain / i,
						res, temp);
				for (int j = 1; j <= count; j++) {
					temp.remove(temp.size() - 1);
				}
				count++;
			}
		}
	}
}
