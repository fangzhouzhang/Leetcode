import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637AverageofLevelsinBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				sum += cur.val;
				if (cur.left != null) q.add(cur.left);
				if (cur.right != null) q.add(cur.right);
			}
			res.add(sum / size);
		}
		return res;
	}
}
