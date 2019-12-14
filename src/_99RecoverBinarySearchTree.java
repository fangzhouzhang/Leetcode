import java.util.ArrayList;
import java.util.List;

public class _99RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		if (root == null) return;
		List<TreeNode> nodes = new ArrayList<>();
		inOrder(root, nodes);
		findMistake(nodes);
	}

	private void inOrder(TreeNode root, List<TreeNode> nodes) {
		if (root == null) return;
		inOrder(root.left, nodes);
		nodes.add(root);
		inOrder(root.right, nodes);
	}

	private void findMistake(List<TreeNode> nodes) {
		TreeNode first = null, second = null;
		for (int i = 0; i < nodes.size() - 1; i++) {
			int pre = nodes.get(i).val;
			int cur = nodes.get(i + 1).val;
			if (pre > cur) {
				second = nodes.get(i + 1);
				if (first == null) first = nodes.get(i);
				else break;
			}
		}
		int tmp = second.val;
		second.val = first.val;
		first.val = tmp;
	}
}
