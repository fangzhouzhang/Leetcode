public class _270ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		long[] arr = new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
		dfs(root, target, arr);
		if (target - arr[0] < arr[1] - target) return (int)arr[0];
		return (int)arr[1];
	}

	private void dfs(TreeNode root, double target, long[] arr) {
		if (root == null) return;
		if (root.val > target) {
			if (root.val - target < arr[1] - target) {
				arr[1] = root.val;
			}
			dfs(root.left, target, arr);
		} else if (root.val < target) {
			if (target - root.val < target - arr[0]) {
				arr[0] = root.val;
			}
			dfs(root.right, target, arr);
		} else {
			arr[0] = root.val;
			arr[1] = root.val;
		}
	}
}
