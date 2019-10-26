import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		if (root == null) {
			return res;
		}
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollLast();
			res.addFirst(node.val);
			if (node.left != null) stack.add(node.left);
			if (node.right != null) stack.add(node.right);
		}
		return res;
	}
}
