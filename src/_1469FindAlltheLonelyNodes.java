import java.util.ArrayList;
import java.util.List;

public class _1469FindAlltheLonelyNodes {
	public List<Integer> getLonelyNodes(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		dfs(root, res);
		return res;
	}

	private void dfs(TreeNode root, List<Integer> res) {
		if (root == null) return;
		if (root.left != null && root.right != null) {
			dfs(root.left, res);
			dfs(root.right, res);
		} else if (root.left != null && root.right == null) {
			res.add(root.left.val);
			dfs(root.left, res);
		} else if (root.left == null && root.right != null) {
			res.add(root.right.val);
			dfs(root.right, res);
		} else return;
	}
}
