import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (q.size() != 0) {
			int size = q.size();
			List<Integer> temp = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				temp.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			res.addFirst(temp);

		}
		return (List)res;
	}
}
