public class LowestCommonAncestorIII {
	/**
	 * @param root: The root of the binary tree.
	 * @param A: A TreeNode
	 * @param B: A TreeNode
	 * @return: Return the LCA of the two nodes.
	 * time : o(2^n)
	 * space: call stack:o(h)
	 */
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
		// write your code here
		TreeNode solution = LCA(root, A, B);
		if (solution != A && solution != B) {
			return solution;
		} else {
			if (solution == A) {
				return LCA(solution, B, B) == B ? A : null;
			} else {
				return LCA(solution, A, A) == A ? B : null;
			}
		}
	}
	public TreeNode LCA(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || root == A || root == B) {
			return root;//base case
		}
		TreeNode left = LCA(root.left, A, B);
		TreeNode right = LCA(root.right, A, B);
		if (left != null && right != null) {
			return root;
		} else if (left != null || right != null) {
			return left != null ? left : right;
		} else {
			return null;
		}
	}
}
