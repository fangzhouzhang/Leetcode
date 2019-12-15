public class _222CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int left = 0;
		TreeNode cur = root;
		while (cur != null) {
			cur = cur.left;
			left++;
		}
		int right = 0;
		cur = root;
		while (cur != null) {
			cur = cur.right;
			right++;
		}
		if (left == right) return (1 << left) - 1;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
}
