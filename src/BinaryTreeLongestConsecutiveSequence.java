public class BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}
	private int dfs(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}

		int left = dfs(root.left, res);
		int right = dfs(root.right, res);
		//
		int local = 0;
		if (left != 0 && root.left.val == root.val + 1) {
			local = left + 1;
		} else {
			local = 1;
		}

		if (right != 0 && root.right.val == root.val + 1) {
			local = Math.max(local, right + 1);
		} else {
			local = Math.max(local, 1);
		}
		res[0] = Math.max(local, res[0]);
		return local;
	}
}
