import java.util.ArrayList;
import java.util.List;

public class _257BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) return res;
		dfs(root, "", res);
		return res;
	}

	private void dfs(TreeNode root, String s, List<String> res) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			res.add(s.length() == 0? s + root.val : s + "->" + root.val);
			return;
		}

		if (s.length() == 0) {
			dfs(root.left, s + root.val, res);
			dfs(root.right, s + root.val, res);
		} else {
			dfs(root.left, s + "->" + root.val, res);
			dfs(root.right, s + "->" + root.val, res);
		}
	}
}
