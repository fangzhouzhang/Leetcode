public class DiameterofBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		dfs(root, res);
		return res[0] - 1;
	}
	private int dfs(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left, res);
		int right = dfs(root.right, res);
		res[0] = Math.max(res[0], 1 + left + right);
		return Math.max(left, right) + 1;
	}
}
