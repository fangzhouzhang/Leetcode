import java.util.ArrayList;
import java.util.List;

public class _113PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		dfs(root, sum, new ArrayList<Integer>(), res);
		return res;
	}

	private boolean dfs(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
		if (root == null) return true;
		tmp.add(root.val);
		boolean left = dfs(root.left, sum - root.val, tmp, res);
		boolean right = dfs(root.right, sum - root.val, tmp, res);
		if (left && right && sum - root.val == 0) res.add(new ArrayList<>(tmp));
		tmp.remove(tmp.size() - 1);
		return false;
	}
}
