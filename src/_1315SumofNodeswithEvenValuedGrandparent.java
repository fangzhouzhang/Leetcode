public class _1315SumofNodeswithEvenValuedGrandparent {
	public int sumEvenGrandparent(TreeNode root) {
		if (root == null) return 0;
		int left = sumEvenGrandparent(root.left);
		int right = sumEvenGrandparent(root.right);
		if (root.val % 2 != 0) return left + right;
		int sum = 0;
		if (root.left != null) {
			if (root.left.left != null) sum += root.left.left.val;
			if (root.left.right != null) sum += root.left.right.val;
		}
		if (root.right != null) {
			if (root.right.left != null) sum += root.right.left.val;
			if (root.right.right != null) sum += root.right.right.val;
		}
		return sum + left + right;
	}
}
