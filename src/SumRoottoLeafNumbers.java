import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		dfs(res, new ArrayList<Integer>(), root);

		return getSum(res);
	}

	private void dfs(List<List<Integer>> res,
					 List<Integer> temp,
					 TreeNode root) {
		if (root == null) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (root.left != null && root.right != null) {
			temp.add(root.val);
			dfs(res, temp, root.left);
			temp.remove(temp.size() - 1);


			temp.add(root.val);
			dfs(res, temp, root.right);
			temp.remove(temp.size() - 1);

		} else if (root.left != null) {
			temp.add(root.val);
			dfs(res, temp, root.left);
			temp.remove(temp.size() - 1);
		} else {
			temp.add(root.val);
			dfs(res, temp, root.right);
			temp.remove(temp.size() - 1);
		}

	}

	private int getSum(List<List<Integer>> res) {
		int sum = 0;
		for (List<Integer> list: res) {
			sum += convertNum(list);
		}
		return sum;
	}
	private int convertNum(List<Integer> list) {
		int res = 0;
		for (Integer num: list) {
			res = res * 10 + num;
		}
		return res;
	}
}
