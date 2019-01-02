public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return hasPath(root, sum);

	}
	public boolean hasPath(TreeNode root, int sum) {
		if (root == null && sum != 0) {
			return false;
		} else if (root == null && sum == 0) {
			return true;
		}

		if (root.left != null && root.right != null) {
			return hasPath(root.left, sum - root.val) ||
					hasPath(root.right, sum - root.val);
		} else if (root.left != null && root.right == null) {
			return hasPath(root.left, sum - root.val);
		} else if (root.left == null && root.right != null) {
			return hasPath(root.right, sum - root.val);
		} else {
			return root.val == sum;
		}

	}
}
