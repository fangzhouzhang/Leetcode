import java.util.*;

public class DeleteNodesAndReturnForest {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> res = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		for (int num : to_delete) {
			set.add(num);
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		res.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (set.contains(node.val)) {
				res.remove(node);
				if (node.left != null) {
					res.add(node.left);
				}
				if (node.right != null) {
					res.add(node.right);
				}
			}
			if (node.left != null) {
				q.add(node.left);
				if (set.contains(node.left.val)) {
					node.left = null;
				}
			}
			if (node.right != null) {
				q.add(node.right);
				if (set.contains(node.right.val)) {
					node.right = null;
				}
			}
		}
		return res;
	}
}
