import java.util.Stack;

public class AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		Stack<ListNode> s1 = new Stack<>();
		Stack<ListNode> s2 = new Stack<>();
		ListNode n1 = l1;
		while (n1 != null) {
			s1.push(n1);
			n1 = n1.next;
		}
		ListNode n2 = l2;
		while (n2 != null) {
			s2.push(n2);
			n2 = n2.next;
		}
		int sum = 0;
		ListNode list = new ListNode(0);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) {
				sum += s1.pop().val;
			}
			if (!s2.isEmpty()) {
				sum += s2.pop().val;
			}
			list.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = list;
			list = head;
			sum /= 10;
		}
		return list.val == 0 ? list.next : list;
	}
}
