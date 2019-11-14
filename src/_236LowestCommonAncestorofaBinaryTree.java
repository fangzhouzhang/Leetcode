public class _236LowestCommonAncestorofaBinaryTree {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     * time: o(n) space: o(h)
     */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (root == p) return p;
		if (root == q) return q;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null && right == null) return null;
		else if (left != null && right == null) return left;
		else if (left == null && right != null) return right;
		else return root;
	}
}
