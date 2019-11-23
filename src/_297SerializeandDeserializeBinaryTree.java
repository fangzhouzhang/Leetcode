public class _297SerializeandDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder res = new StringBuilder();
		strHelper(root, res);
		res.deleteCharAt(res.length() - 1);
		return new String(res);
	}
	private void strHelper(TreeNode root, StringBuilder res) {
		if (root == null) {
			res.append("null,");
			return;
		}
		res.append(root.val + ",");
		strHelper(root.left, res);
		strHelper(root.right, res);
	}
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] arr = data.split(",");
		int[] level = new int[1];
		return constructTree(arr, level);
	}
	private TreeNode constructTree(String[] arr, int[] level) {
		if (level[0] == arr.length || arr[level[0]].equals("null")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(arr[level[0]]));
		level[0]++;
		root.left = constructTree(arr, level);
		level[0]++;
		root.right = constructTree(arr, level);
		return root;
	}
}
