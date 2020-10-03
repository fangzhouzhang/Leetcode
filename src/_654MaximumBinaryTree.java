public class _654MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return dfs(nums, 0, nums.length - 1);
	}

	private TreeNode dfs(int[] a, int left, int right) {
		if (left > right) return null;
		int maxIdx = left, max = a[left];
		for (int i = left; i <= right; i++) {
			if (max < a[i]) {
				max = a[i];
				maxIdx = i;
			}
		}
		TreeNode root = new TreeNode(max);
		root.left = dfs(a, left, maxIdx - 1);
		root.right = dfs(a, maxIdx + 1, right);
		return root;
	}
}
