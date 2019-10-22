import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		return constructTree(list, 0 , list.size() - 1);
	}

	private TreeNode constructTree(List<Integer> list, int l, int r) {
		if (l > r) {
			return null;
		}
		int rootIdx = (l + r) / 2;
		TreeNode root = new TreeNode(list.get(rootIdx));
		root.left = constructTree(list, l, rootIdx - 1);
		root.right = constructTree(list, rootIdx + 1, r);
		return root;
	}
}
