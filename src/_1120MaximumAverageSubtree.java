public class _1120MaximumAverageSubtree {
	private double res = Double.MIN_VALUE;
	public double maximumAverageSubtree(TreeNode root) {
		dfs(root);
		return res;
	}

	private int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[2];
		}
		int[] l = dfs(root.left);
		int[] r = dfs(root.right);
		res = Math.max(res, (l[0] + r[0] + root.val) * 1.0 / (l[1] + r[1] + 1));
		int[] cur = new int[2];
		cur[0] = l[0] + r[0] + root.val;
		cur[1] = l[1] + r[1] + 1;
		return cur;
	}
}
