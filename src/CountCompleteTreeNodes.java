public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getLeftHeight(root.left);
		int right = getRightHeight(root.right);
		if (left == right) {
			return (1 << left) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	private int getLeftHeight(TreeNode root) {
		if (root == null) {
			return 1;
		}
		int h = 1;
		while (root != null) {
			root = root.left;
			h++;
		}
		return h;
	}
	private int getRightHeight(TreeNode root) {
		if (root == null) {
			return 1;
		}
		int h = 1;
		while (root != null) {
			root = root.right;
			h++;
		}
		return h;
	}
}
