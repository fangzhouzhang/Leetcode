import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		dfs(res, root, "", 0);
		return res;
	}
	private void dfs(List<String> res,
					 TreeNode root,
					 String path,
					 int level) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			if (level == 0) {
				res.add(new String(path + root.val));
			} else {
				res.add(new String(path + "->" + root.val));
			}
			return;
		}
		if (level == 0) {
			dfs(res, root.left, path + root.val, level + 1);
			dfs(res, root.right, path + root.val, level + 1);
		} else {
			dfs(res, root.left, path + "->" + root.val, level + 1);
			dfs(res, root.right, path + "->" + root.val, level + 1);

		}
	}
}
