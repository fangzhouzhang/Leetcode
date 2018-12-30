public class RangeSumofBST {
	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		dfs(root, L, R, res);
		return res[0];
	}
	private void dfs(TreeNode root, int L, int R, int[] res) {
		if (root == null) {
			return;
		}


		if (root.val >= L && root.val <= R) {
			res[0] += root.val;
		}

		dfs(root.left, L, R, res);
		dfs(root.right, L, R, res);
	}
}
