import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	/**
	 * @param root: A Tree
	 * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
	 * time: o(n) space: o(n)
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.offerFirst(root);
		int cnt = 0;
		while (!deque.isEmpty()) {
			if (cnt % 2 == 0) {
				int size = deque.size();
				List<Integer> temp = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.pollFirst();
					temp.add(node.val);
					if (node.left != null) {
						deque.offerLast(node.left);
					}
					if (node.right != null) {
						deque.offerLast(node.right);
					}
				}
				res.add(temp);
				cnt++;
			} else {
				int size = deque.size();
				List<Integer> temp = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.pollLast();
					temp.add(node.val);
					if (node.right != null) {
						deque.offerFirst(node.right);
					}
					if (node.left != null) {
						deque.offerFirst(node.left);
					}

				}
				res.add(temp);
				cnt++;
			}
		}

		return res;
	}
}
