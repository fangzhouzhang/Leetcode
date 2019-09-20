import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		if (root == null) return new ArrayList<Integer>();
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode n = q.poll();
				max = Math.max(max, n.val);
				if (n.left != null) q.add(n.left);
				if (n.right != null) q.add(n.right);
			}
			res.add(max);
		}
		return res;
	}
}
