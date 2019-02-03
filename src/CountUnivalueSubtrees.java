public class CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		dfs(root, root.val, res);
		return res[0];
	}
	private boolean dfs(TreeNode root, int father, int[] res) {
		if (root == null) {
			return true;
		}

		boolean left = dfs(root.left, root.val, res);
		boolean right = dfs(root.right, root.val, res);

		if (left == true && right == true) {
			res[0]++;
			if (root.val == father) {
				return true;
			}
		}

		return false;
	}
}
