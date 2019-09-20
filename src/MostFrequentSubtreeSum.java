import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
	private int max = 0;
	private Map<Integer, Integer> map = new HashMap<>();
	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		List<Integer> tmp = new ArrayList<>();
		dfs(root, tmp);
		int[] res = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			res[i] = tmp.get(i);
		}
		return res;
	}

	private int dfs(TreeNode root, List<Integer> tmp) {
		if (root == null) return 0;
		int left = dfs(root.left, tmp);
		int right = dfs(root.right, tmp);
		int sum = left + right + root.val;
		int cur = map.getOrDefault(sum, 0) + 1;
		map.put(sum, cur);
		if (cur >= max) {
			if (cur > max) tmp.clear();
			tmp.add(sum);
			max = cur;
		}
		return sum;
	}
}
