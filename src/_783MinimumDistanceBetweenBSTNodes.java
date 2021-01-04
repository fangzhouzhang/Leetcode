import java.util.ArrayList;
import java.util.List;

public class _783MinimumDistanceBetweenBSTNodes {
	List<Integer> nums;
	public int minDiffInBST(TreeNode root) {
		if (root == null) return 0;
		nums = new ArrayList<>();
		dfs(root);
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < nums.size(); i++) {
			res = Math.min(res, nums.get(i) - nums.get(i - 1));
		}
		return res;
	}

	private void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.left);
		nums.add(root.val);
		dfs(root.right);
	}
}
