import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
		dfs(res, new ArrayList<Integer>(), k, n, 0, 1);
		return res;
	}
	private void dfs(List<List<Integer>> res,
					 List<Integer> temp,
					 int k,
					 int target,
					 int sum,
					 int num) {
		// System.out.println(num + " num ");
		if (temp.size() == k && sum == target) {
			res.add(new ArrayList<>(temp));
			// System.out.println(" 111 ");
			return;
		} else if (temp.size() >= k && sum != target) {
			// System.out.println(" 222 ");
			return;
		} else if (num > 9) {
			// System.out.println(" 333 ");
			return;
		} else if (sum > target) {
			// System.out.println(" 444 ");
			return;
		}

		for (int i = 0; i < 2 && target - sum - num * i >= 0; i++) {
			addNum(temp, num, i);
			dfs(res, temp, k, target, sum + num * i, num + 1);
			removeNum(temp, i);
		}
	}
	private void addNum(List<Integer> temp,
						int target,
						int num) {
		for (int i = 0; i < num; i++) {
			temp.add(target);
		}
	}
	private void removeNum(List<Integer> temp,
						   int num) {
		for (int i = 0; i < num; i++) {
			temp.remove(temp.size() - 1);
		}
	}
}
