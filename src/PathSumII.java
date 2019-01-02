import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}

		dfs(root, sum, res, new ArrayList<Integer>());
		return res;
	}

	private void dfs(TreeNode root,
					 int sum,
					 List<List<Integer>> res,
					 List<Integer> temp) {
		if (root == null && sum == 0) {
			res.add(new ArrayList<Integer>(temp));
			return;
		} else if (root == null && sum != 0) {
			return;
		}

		if (root.left != null && root.right != null) {
			temp.add(root.val);
			dfs(root.left, sum - root.val, res, temp);
			temp.remove(temp.size() - 1);


			temp.add(root.val);
			dfs(root.right, sum - root.val, res, temp);
			temp.remove(temp.size() - 1);

		} else if (root.left != null && root.right == null) {
			temp.add(root.val);
			dfs(root.left, sum - root.val, res, temp);
			temp.remove(temp.size() - 1);
		} else if (root.left == null && root.right != null) {
			temp.add(root.val);
			dfs(root.right, sum - root.val, res, temp);
			temp.remove(temp.size() - 1);
		} else {
			temp.add(root.val);
			dfs(root.right, sum - root.val, res, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
