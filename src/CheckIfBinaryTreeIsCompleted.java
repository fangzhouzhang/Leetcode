import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsCompleted {
	/**
	 * @param root
	 * @return
	 * time: o(n) space: o(n)
	 */
	public boolean isCompleted(TreeNode root) {
		// Write your solution here
		if (root == null) {
			return true;
		}
		boolean hasChild = true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null &&
						node.right != null) {
					if (hasChild == false) {
						return false;
					}
					queue.add(node.left);
					queue.add(node.right);
				} else if (node.right != null) {
					return false;
				} else if (node.left != null) {
					if (hasChild == false) {
						return false;
					}
					if (node.left != null) {
						queue.add(node.left);
					}
					hasChild = false;
				} else {
					hasChild = false;
				}
			}
		}
		return true;
	}
}
