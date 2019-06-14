import java.util.LinkedList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		LinkedList<Integer> res = new LinkedList<>();
		if (nums.length == 0) {
			return (List)res;
		}
		TreeNode root = new TreeNode(nums[nums.length - 1], 0, 1);
		res.addFirst(0);
		for (int i = nums.length - 2; i >= 0; i--) {
			res.addFirst(dfs(root, nums[i]));
		}
		return (List)res;
	}
	private int dfs(TreeNode cur, int tar) {
		int ret = 0;
		while (cur != null) {
			if (cur.val == tar) {
				ret += cur.small;
				cur.same += 1;
				break;
			} else if (cur.val < tar) {
				//go right
				ret += cur.small + cur.same;
				if (cur.right == null) {

					cur.right = new TreeNode(tar, 0, 1);
					break;
				} else {
					// ret += cur.small + cur.same;
					cur = cur.right;
				}
			} else {
				cur.small += 1;
				if (cur.left == null) {
					cur.left = new TreeNode(tar, 0, 1);
					break;
				} else {
					cur = cur.left;
				}
			}
		}
		return ret;
	}
	private class TreeNode {
		private int val, small, same;
		private TreeNode left, right;
		public TreeNode(int val, int small, int same) {
			this.val = val;
			this.small = small;
			this.same = same;
			left = null;
			right = null;
		}
	}
}
