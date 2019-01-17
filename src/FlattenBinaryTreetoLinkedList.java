import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		List<TreeNode> list = new ArrayList<>();
		dfs(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			TreeNode node = list.get(i);
			node.left = null;
			node.right = list.get(i + 1);
		}
		return;
	}
	private void dfs(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		list.add(root);
		dfs(root.left, list);
		dfs(root.right, list);
	}
}
