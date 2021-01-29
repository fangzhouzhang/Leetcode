import java.util.HashMap;
import java.util.Map;

public class _1740FindDistanceinaBinaryTree {
	Map<Integer, Integer> map = new HashMap<>();
	public int findDistance(TreeNode root, int p, int q) {
		if (root == null) return 0;
		if (p == q) return 0;
		TreeNode ancestor = lca(root, p, q);
		dfs(root, root);
		int res = 0;
		if (ancestor.val == p || ancestor.val == q) {
			int start = (ancestor.val == p) ? q : p;
			while (start != ancestor.val) {
				res++;
				start = map.get(start);
			}
			return res;
		} else {
			int start = p;
			while (start != ancestor.val) {
				res++;
				start = map.get(start);
			}
			start = q;
			while (start != ancestor.val) {
				res++;
				start = map.get(start);
			}
			return res;
		}
	}

	private void dfs(TreeNode root, TreeNode pre) {
		if (root == null) return;
		map.put(root.val, pre.val);
		dfs(root.left, root);
		dfs(root.right, root);
	}

	private TreeNode lca(TreeNode root, int p, int q) {
		if (root == null || root.val == p || root.val == q) return root;
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		if (left != null && right != null) return root;
		if (left == null && right != null) return right;
		if (left != null && right == null) return left;
		return null;
	}
}
