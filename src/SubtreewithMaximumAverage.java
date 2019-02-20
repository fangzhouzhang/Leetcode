public class SubtreewithMaximumAverage {
	public class Solution {
		/**
		 * time: o(n) space: o(h)
		 * @param root: the root of binary tree
		 * @return: the root of the maximum average of subtree
		 */
		public TreeNode findSubtree2(TreeNode root) {
			// write your code here
			if (root == null) {
				return null;
			}
			TreeNode[] arr = new TreeNode[1];
			Double[] avg = new Double[1];
			avg[0] = Integer.MIN_VALUE * 1.0;
			Result r = dfs(root, arr, avg);
			return arr[0];

		}
		private Result dfs(TreeNode root, TreeNode[] arr, Double[] avg) {
			if (root == null) {
				return new Result(0, 0);
			}
			Result left = dfs(root.left, arr, avg);
			Result right = dfs(root.right, arr, avg);
			int curSum = left.sum + right.sum + root.val;
			int curCnt = left.count + right.count + 1;
			double curAvg = curSum * 1.0 / curCnt;
			// System.out.println("curAvg " + curAvg + " " + avg[0]);
			if (curAvg > avg[0]) {
				// System.out.println("haha");
				arr[0] = root;
				avg[0] = curAvg;
			}
			return new Result(curCnt, curSum);
		}
		private class Result {
			private int count;
			private int sum;
			public Result(int count, int sum) {
				this.count = count;
				this.sum = sum;
			}

		}
	}
}
