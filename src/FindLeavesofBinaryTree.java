import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, root);
		return res;
	}

	private int dfs(List<List<Integer>> res, TreeNode root) {
		if (root == null) {
			return -1;
		}
		int level = Math.max(dfs(res, root.left), dfs(res, root.right)) + 1;
		if (res.size() < level + 1) {
			res.add(new ArrayList<Integer>());
		}
		res.get(level).add(root.val);
		return level;
	}
}
