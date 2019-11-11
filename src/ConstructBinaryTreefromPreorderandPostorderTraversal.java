public class ConstructBinaryTreefromPreorderandPostorderTraversal {
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		return dfs(pre, 0, post, 0, pre.length);
	}

	private TreeNode dfs(int[] pre, int i, int[] post, int j, int n) {
		if (n <= 0) return null;
		if (n == 1) return new TreeNode(pre[i]);

		int target = pre[i + 1];
		int startIdx = j;
		int endIdx = j;
		while (endIdx < post.length && post[endIdx] != target) {
			endIdx++;
		}
		int leftLen = endIdx - startIdx + 1;
		TreeNode root = new TreeNode(pre[i]);
		root.left = dfs(pre, i + 1, post, j, leftLen);
		root.right = dfs(pre, i + 1 + leftLen, post, endIdx + 1, n - 1 - leftLen);
		return root;
	}
}
