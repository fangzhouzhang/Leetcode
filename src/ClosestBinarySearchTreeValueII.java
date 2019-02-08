import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>(k);
		if (root == null) {
			return res;
		}

		Stack<TreeNode> post = new Stack<>();
		Stack<TreeNode> pre = new Stack<>();

//         dfs(post, pre, root, target);

//         addElement(post, pre, target, res, k);
		TreeNode cur = root;
		while (cur != null) {
			if (cur.val >= target) {
				post.add(cur);
				cur = cur.left;
			} else {
				pre.add(cur);
				cur = cur.right;
			}
		}

		while (k > 0) {
			double diff = 0;
			if (pre.size() > 0 && post.size() > 0) {
				diff = Math.abs(pre.peek().val - target) - Math.abs(post.peek().val - target);
				// System.out.println(Math.abs(pre.peek().val - target) + "    " + Math.abs(post.peek().val - target) + "    " + diff);
				if (diff < 0) {
					// System.out.println("< 0");
					res.add(getNextPre(pre).val);
				} else {
					// System.out.println("> 0");
					res.add(getNextPost(post).val);
				}
			} else if (pre.size() > 0) {
				res.add(getNextPre(pre).val);
			} else {
				res.add(getNextPost(post).val);
			}
			k--;
		}

		return res;
	}

	private TreeNode getNextPre(Stack<TreeNode> pre) {
		TreeNode node = pre.pop();
		TreeNode cur = node;
		cur = cur.left;
		while (cur != null) {
			pre.push(cur);
			cur = cur.right;
		}
		return node;
	}
	private TreeNode getNextPost(Stack<TreeNode> post) {
		TreeNode node = post.pop();
		TreeNode cur = node;
		cur = cur.right;
		while (cur != null) {
			post.push(cur);
			cur = cur.left;
		}
		return node;
	}
}
