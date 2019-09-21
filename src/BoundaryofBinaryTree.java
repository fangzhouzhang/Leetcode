import java.util.ArrayList;
import java.util.List;

public class BoundaryofBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		res.add(root.val);
		helper(root.left, true, false, res);
		helper(root.right, false, true, res);
		return res;
	}

	private void helper(TreeNode root, boolean l, boolean r, List<Integer> res) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			res.add(root.val);
			return;
		}
		if (l) {
			res.add(root.val);
		}
		helper(root.left, l && root.left != null, r && root.right == null, res);
		helper(root.right, l && root.left == null, r && root.right != null, res);
		if (r) {
			res.add(root.val);
		}
	}
}
