import java.util.HashMap;
import java.util.Map;

public class _234PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		Map<Integer, ListNode> map = new HashMap<>();
		int n = 0;
		ListNode cur = head;
		while (cur != null) {
			map.put(n++, cur);
			cur = cur.next;
		}
		int i = 0, j = n - 1;
		while (i < j) {
			if (map.get(i).val != map.get(j).val) return false;
			i++;
			j--;
		}
		return true;
	}
}
