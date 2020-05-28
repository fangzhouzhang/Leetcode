import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (null == root) return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (i == size - 1) res.add(cur.val);
				if (null != cur.left) q.add(cur.left);
				if (null != cur.right) q.add(cur.right);
			}
		}
		return res;
	}
}
