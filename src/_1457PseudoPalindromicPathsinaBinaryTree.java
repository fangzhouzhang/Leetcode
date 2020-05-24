public class _1457PseudoPalindromicPathsinaBinaryTree {
	public int pseudoPalindromicPaths (TreeNode root) {
		if (root == null) return 0;
		int[] map = new int[10];
		int[] res = new int[1];
		dfs(root, map, res);
		return res[0];
	}

	private void dfs(TreeNode root, int[] map, int[] res) {
		if (root.left == null && root.right == null) {
			map[root.val]++;
			int cnt = 0;
			for (int i = 1; i <= 9; i++) {
				if (map[i] % 2 == 1) cnt++;
			}
			if (cnt <= 1) res[0]++;
			map[root.val]--;
		} else if (root.left != null && root.right == null) {
			map[root.val]++;
			dfs(root.left, map, res);
			map[root.val]--;
		} else if (root.left == null && root.right != null) {
			map[root.val]++;
			dfs(root.right, map, res);
			map[root.val]--;
		} else {
			map[root.val]++;
			dfs(root.left, map, res);
			dfs(root.right, map, res);
			map[root.val]--;
		}
	}
}
