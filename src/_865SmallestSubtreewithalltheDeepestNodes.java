import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _865SmallestSubtreewithalltheDeepestNodes {
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) return root;
		int height = getHeight(root);
		int h = 1;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		Queue<TreeNode> lca = new LinkedList<>();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (h == height) lca.add(cur);
				if (cur.left != null) q.add(cur.left);
				if (cur.right != null) q.add(cur.right);
			}
			h++;
		}
		Set<Integer> set = new HashSet<>();
		TreeNode res = null;
		while (lca.size() > 1) {
			TreeNode a = lca.poll();
			TreeNode b = lca.poll();
			TreeNode father = findLca(a, b, root);
			res = father;
			if (!set.contains(father.val)) {
				set.add(father.val);
				lca.add(father);
			}
		}
		return lca.size() > 0 ? lca.poll() : res;
	}

	private TreeNode findLca(TreeNode a, TreeNode b, TreeNode root) {
		if (root == null || root == a || root == b) return root;
		TreeNode left = findLca(a, b, root.left);
		TreeNode right = findLca(a, b, root.right);
		if (left != null && right != null) {
			return root;
		}
		if (left != null && right == null) return left;
		if (left == null && right != null) return right;
		return null;
	}

	private int getHeight(TreeNode root) {
		if (root == null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
