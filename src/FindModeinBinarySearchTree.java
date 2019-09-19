import java.util.ArrayList;
import java.util.List;

public class FindModeinBinarySearchTree {
	private int max = 0;
	private int cnt = 1;
	private TreeNode pre;
	public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}

	private void helper(TreeNode root, List<Integer> res) {
		if (root == null) return;
		helper(root.left, res);
		if (pre != null) {
			cnt = pre.val == root.val ? cnt + 1 : 1;
		}
		if (cnt >= max) {
			if (cnt > max) {res.clear();}
			res.add(root.val);
			max = cnt;
		}
		pre = root;
		helper(root.right, res);
	}
}
