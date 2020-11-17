import java.util.Stack;

public class _530MinimumAbsoluteDifferenceinBST {
	public int getMinimumDifference(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		int res = Integer.MAX_VALUE;
		Integer prev = null;
		TreeNode cur = root;
		while (cur != null ||stack.size() > 0) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			if (stack.size() > 0) {
				cur = stack.pop();
				if (prev != null) {
					res = Math.min(res, cur.val - prev);
				}
				prev = cur.val;
				cur = cur.right;
			}
		}
		return res;
	}
}
