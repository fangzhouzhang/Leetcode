public class LargestBSTSubtree {
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}
	private Result dfs(TreeNode root, int[] res) {
		if (root == null) {
			return null;
		}
		Result left = dfs(root.left, res);
		Result right = dfs(root.right, res);
		if (left == null && right == null) {
			res[0] = Math.max(res[0], 1);
			return new Result(root.val, root.val, 1);
		} else if (right == null) {
			// return null;
			if (left.max >= root.val) {
				return new Result(left.min, root.val, Integer.MIN_VALUE);
			}
			res[0] = Math.max(res[0], left.size + 1);
			return new Result(left.min, root.val, left.size + 1);
		}
		else if (left == null) {
			if (right.min <= root.val) {
				return new Result(root.val, right.max, Integer.MIN_VALUE);
			}
			res[0] = Math.max(res[0], right.size + 1);
			return new Result(root.val, right.max, right.size + 1);
		}
		else {
			if (left.max >= root.val || right.min <= root.val) {
				return new Result(left.min, right.max, Integer.MIN_VALUE);
			}
			res[0] = Math.max(res[0], left.size + right.size + 1);
			return new Result(left.min, right.max, left.size + right.size + 1);
		}
	}
	private class Result {
		private int min;
		private int max;
		private int size;
		public Result(int min, int max, int size) {
			this.min = min;
			this.max = max;
			this.size = size;
		}
	}
}
