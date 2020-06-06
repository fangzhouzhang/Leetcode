public class _235LowestCommonAncestorofaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root.val == p.val || root.val == q.val) return root;
		TreeNode left = null;
		TreeNode right = null;
		if ((p.val < root.val && root.val < q.val) || (p.val > root.val && root.val > q.val)) {
			left = lowestCommonAncestor(root.left, p, q);
			right = lowestCommonAncestor(root.right, p, q);
		} else if (p.val > root.val && root.val < q.val) {
			right = lowestCommonAncestor(root.right, p, q);
		} else {
			left = lowestCommonAncestor(root.left, p, q);
		}
		if (left == null && right == null) return null;
		else if (left == null && right != null) return right;
		else if (left != null && right == null) return left;
		else return root;
	}
}
