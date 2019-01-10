public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		dfs(root, res);
		return res[0];
	}
	private int dfs(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}
		res[0] = Math.max(res[0], root.val);
		int left = dfs(root.left, res);
		res[0] = Math.max(res[0], root.val + left);
		int right = dfs(root.right, res);
		res[0] = Math.max(res[0], root.val + right);
		res[0] = Math.max(res[0], root.val + right + left);
		int rootAndChild = Math.max(left, right) + root.val;
		return Math.max(rootAndChild, root.val);
	}
}
