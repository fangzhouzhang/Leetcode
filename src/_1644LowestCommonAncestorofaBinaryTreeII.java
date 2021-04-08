public class _1644LowestCommonAncestorofaBinaryTreeII {
	int cnt = 0;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode lca = dfs(root, p, q);
		return cnt == 2 ? lca : null;
	}

	private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return root;
		TreeNode left = dfs(root.left, p, q);
		TreeNode right = dfs(root.right, p, q);
		if (root == q || root == p) {
			cnt++;
			return root;
		}


		if (left != null && right != null) return root;
		if (left == null && right != null) return right;
		if (left != null && right == null) return left;
		return null;
	}
}
