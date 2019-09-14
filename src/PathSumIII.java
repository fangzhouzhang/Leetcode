public class PathSumIII {
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		return dfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	private int dfs(TreeNode root, int sum, int cur) {
		if (root == null) {
			return 0;
		}
		cur = cur + root.val;
		if (cur == sum) {
			return 1 + dfs(root.left, sum, cur) + dfs(root.right, sum, cur);
		}
		return dfs(root.left, sum, cur) + dfs(root.right, sum, cur);
	}
}
