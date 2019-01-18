public class InorderSuccessorinBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		boolean[] isFind = new boolean[1];
		boolean[] isDone = new boolean[1];
		TreeNode[] res = new TreeNode[1];
		dfs(root, p, isFind, res, isDone);
		return res[0];
	}
	private void dfs(TreeNode root, TreeNode p, boolean[] isFind, TreeNode[] res, boolean[] isDone) {
		if (root == null) {
			return;
		}
		dfs(root.left, p, isFind, res, isDone);
		if (isDone[0] == true) {
			return;
		}
		if (isFind[0] == true) {
			res[0] = root;
			isDone[0] = true;
			return;
		}
		if (root.val == p.val) {
			isFind[0] = true;
		}
		dfs(root.right, p, isFind, res, isDone);
	}
}
