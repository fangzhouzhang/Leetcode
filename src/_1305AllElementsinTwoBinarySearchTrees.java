import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1305AllElementsinTwoBinarySearchTrees {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> res = new ArrayList<>();
		if (root1 == null && root2 == null) return res;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		inorder(root1, s1);
		inorder(root2, s2);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			TreeNode node = null;
			int size1 = s1.size();
			int size2 = s2.size();
			if (s1.isEmpty()) node = s2.pop();
			else if (s2.isEmpty()) node = s1.pop();
			else node = s1.peek().val < s2.peek().val ? s1.pop() : s2.pop();
			res.add(node.val);
			if (size1 == s1.size()) {
				inorder(node.right, s2);
			} else inorder(node.right, s1);
		}
		return res;
	}

	private void inorder(TreeNode node, Stack<TreeNode> s) {
		if (node == null) return;
		s.push(node);
		inorder(node.left, s);
	}
}
