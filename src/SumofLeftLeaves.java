import java.util.LinkedList;
import java.util.Queue;

public class SumofLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int sum = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left != null && node.left.left == null && node.left.right == null) {
				sum += node.left.val;
			}
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
		return sum;
	}

	public int sumOfLeftLeaves1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.val + sumOfLeftLeaves1(root.right);
		}
		return sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
	}
}
