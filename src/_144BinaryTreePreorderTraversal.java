import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || stack.size() > 0) {
			while (root != null) {
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop().right;
		}
		return res;
	}
}
