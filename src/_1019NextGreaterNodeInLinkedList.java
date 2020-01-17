import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1019NextGreaterNodeInLinkedList {
	public int[] nextLargerNodes(ListNode head) {
		if (head == null) return new int[0];
		Map<ListNode, Integer> map = new HashMap<>();
		int i = 0;
		ListNode cur = head;
		while (cur != null) {
			map.put(cur, i++);
			cur = cur.next;
		}
		int[] res = new int[i];
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			if (stack.isEmpty() || stack.peek().val >= head.val) {
				stack.push(head);
				head = head.next;
			} else {
				while (!stack.isEmpty() && stack.peek().val < head.val) {
					res[map.get(stack.pop())] = head.val;
				}
			}
		}
		return res;
	}
}
