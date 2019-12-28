public class _104MaximumDepthofBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     * time : o(n) space : o(h)
     */
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
