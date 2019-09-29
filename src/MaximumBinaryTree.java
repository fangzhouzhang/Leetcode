public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums.length == 0) return null;
		return dfs(nums, 0, nums.length - 1);
	}

	private TreeNode dfs(int[] nums, int start, int end) {
		if (start > end) return null;
		int maxIdx = getMax(nums, start, end);
		TreeNode root = new TreeNode(nums[maxIdx]);
		root.left = dfs(nums, start, maxIdx - 1);
		root.right = dfs(nums, maxIdx + 1, end);
		return root;
	}

	private int getMax(int[] nums, int start, int end) {
		int max = start;
		for (int i = start; i <= end; i++) {
			if (nums[i] > nums[max]) {
				max = i;
			}
		}
		return max;
	}
}
