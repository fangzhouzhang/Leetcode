public class ConvertBSTtoGreaterTree {
	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		int[] sum = new int[1];
		helper(root, sum);
		return root;
	}

	private void helper(TreeNode root, int[] sum) {
		if (root == null) {
			return;
		}
		helper(root.right, sum);
		root.val += sum[0];
		sum[0] = root.val;
		helper(root.left, sum);
	}
}
