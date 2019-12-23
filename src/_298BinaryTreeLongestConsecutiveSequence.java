public class _298BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		if (root == null) return 0;
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}

	private int dfs(TreeNode node, int[] res) {
		if (node == null ) return 0;
		int max = 1;
		int left = dfs(node.left, res);
		int right = dfs(node.right, res);
		if (node.left != null && node.val == node.left.val - 1) {
			max = Math.max(max, left + 1);
		}
		if (node.right != null && node.val == node.right.val - 1) {
			max = Math.max(max, right + 1);
		}
		res[0] = Math.max(res[0], max);
		return max;
	}
}
