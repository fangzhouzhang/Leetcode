public class _1448CountGoodNodesinBinaryTree {
	public int goodNodes(TreeNode root) {
		if (null == root) return 0;
		int[] res = new int[1];
		dfs(root, res, Integer.MIN_VALUE);
		return res[0];
	}

	private void dfs(TreeNode root, int[] res, int max) {
		if (null == root) return ;
		if (root.val >= max) res[0]++;
		dfs(root.left, res, Math.max(root.val, max));
		dfs(root.right, res, Math.max(root.val, max));
	}
}
