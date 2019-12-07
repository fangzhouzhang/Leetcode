public class _337HouseRobberIII {
	public int rob(TreeNode root) {
		if (root == null) return 0;
		int[] result = dfs(root);
		return Math.max(result[0], result[1]);
	}

	private int[] dfs(TreeNode root) {
		if (root == null) return new int[2];
		//res[0] if not robbing cur root.val
		int[] l = dfs(root.left);
		int[] r = dfs(root.right);
		int notRob = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
		int rob = l[0] + r[0] + root.val;
		return new int[]{notRob, rob};
	}
}
