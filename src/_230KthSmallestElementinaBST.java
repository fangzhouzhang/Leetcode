public class _230KthSmallestElementinaBST {
	private int k = 0;
	public int kthSmallest(TreeNode root, int k) {
		if (root == null || k < 1) return -1;
		this.k = k;
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}

	private void dfs(TreeNode root, int[] res) {
		if (root == null) return;
		dfs(root.left, res);
		if (k == 0) return;
		res[0] = root.val;
		k--;
		dfs(root.right, res);
	}
}
