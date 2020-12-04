import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				res.add(cur.val);
				stack.push(cur);
				cur = cur.right;
			}
			if (!stack.isEmpty()) cur = stack.pop().left;
		}
		Collections.reverse(res);
		return res;
	}
}
