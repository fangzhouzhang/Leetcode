public class BinaryTreeLongestConsecutiveSequenceII {
	private int max = 0;
	public int longestConsecutive(TreeNode root) {
		if (root == null) return 0;
		dfs(root);
		return max;
	}

	private int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[2];
		}
		int inc = 1, dec = 1;
		if (root.left != null) {
			int[] l = dfs(root.left);
			if (root.val == root.left.val + 1) {
				dec = l[0] + 1;
			} else if (root.val == root.left.val - 1) {
				inc = l[1] + 1;
			}
		}

		if (root.right != null) {
			int[] r = dfs(root.right);
			if (root.val == root.right.val + 1) {
				dec = Math.max(dec, r[0] + 1);
			} else if (root.val == root.right.val - 1) {
				inc = Math.max(inc, r[1] + 1);
			}
		}
		max = Math.max(max, dec + inc - 1);
		return new int[]{dec, inc};
	}
}
