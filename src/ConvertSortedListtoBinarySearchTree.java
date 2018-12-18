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
		return constructTree(list);
	}
	private TreeNode constructTree(List<Integer> list) {
		if (list.size() == 0) {
			return null;
		}
		int size = list.size();
		int rootIdx = (0 + size) / 2;
		TreeNode root = new TreeNode(list.get(rootIdx));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (i < rootIdx) {
				left.add(list.get(i));
			} else if (i > rootIdx) {
				right.add(list.get(i));
			}
		}
		root.left = constructTree(left);
		root.right = constructTree(right);
		return root;
	}
}
