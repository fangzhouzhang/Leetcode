import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		dfs(root, res, 0);

		return res[0];
	}

	private void dfs(TreeNode root, int[] res, int sum) {
		if (root == null) {
			return;
		}
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			res[0] += sum;
			return;
		}
		dfs(root.left, res, sum);
		dfs(root.right, res, sum);
	}
}
