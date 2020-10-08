import java.util.LinkedList;
import java.util.Queue;

public class _1609EvenOddTree {
	public boolean isEvenOddTree(TreeNode root) {
		if (root == null) return true;
		Queue<TreeNode> q = new LinkedList<>();
		int level = 0;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			int[] tmp = new int[size];
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				tmp[i] = node.val;
				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
			}
			if (level % 2 == 0) {
				//increasing
				for (int i = 0; i < size - 1; i++) {
					if (tmp[i] % 2 == 0 || tmp[i + 1] % 2 == 0) return false;
					if (tmp[i] >= tmp[i + 1]) return false;
				}
				if (tmp[size - 1] % 2 == 0) return false;
			} else {
				for (int i = 0; i < size - 1; i++) {
					if (tmp[i] % 2 != 0 || tmp[i + 1] % 2 != 0) return false;
					if (tmp[i] <= tmp[i + 1]) return false;
				}
				if (tmp[size - 1] % 2 != 0) return false;
			}
			level++;
		}
		return true;
	}
}
