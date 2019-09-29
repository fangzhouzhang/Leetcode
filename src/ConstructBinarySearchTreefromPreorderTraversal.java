public class ConstructBinarySearchTreefromPreorderTraversal {
	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder.length == 0) return null;
		return dfs(preorder, 0, preorder.length - 1);
	}

	private TreeNode dfs(int[] preorder, int start, int end) {
		if (start > end) return null;
		TreeNode root = new TreeNode(preorder[start]);
		int split = start + 1;
		while (split <= end && preorder[split] <= preorder[start]) {
			split++;
		}
		root.left = dfs(preorder, start + 1, split - 1);
		root.right = dfs(preorder, split, end);
		return root;
	}
}
