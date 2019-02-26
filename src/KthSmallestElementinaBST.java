public class KthSmallestElementinaBST {
	/**
	 * time: o(n) space: o(n)
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
		int[] num = new int[1];
		num[0] = 1;
		Integer[] res = new Integer[1];
		dfs(num, root, k, res);
		return res[0];
	}
	private void dfs(int[] num, TreeNode root, int k, Integer[] res) {
		if (root == null) {
			return;
		}
		dfs(num, root.left, k, res);
		if (res[0] != null) {
			return;
		}
		if (k == num[0]) {
			res[0] = root.val;
			return;
		} else {
			num[0] += 1;
		}
		dfs(num, root.right, k, res);

	}
}
