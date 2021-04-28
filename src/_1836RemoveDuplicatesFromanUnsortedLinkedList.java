import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1836RemoveDuplicatesFromanUnsortedLinkedList {
	public ListNode deleteDuplicatesUnsorted(ListNode head) {
		Map<Integer, List<ListNode>> map = new HashMap<>();
		ListNode cur = head;
		while (cur != null) {
			if (!map.containsKey(cur.val)) map.put(cur.val, new ArrayList<>());
			map.get(cur.val).add(cur);
			cur = cur.next;
		}
		Set<ListNode> set = new HashSet<>();
		for (Map.Entry<Integer, List<ListNode>> e : map.entrySet()) {
			if (e.getValue().size() == 1) {
				set.add(e.getValue().get(0));
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode curNode = dummy;
		cur = head;
		while (cur != null) {
			if (set.contains(cur)) {
				curNode.next = cur;
				curNode = curNode.next;
			}
			cur = cur.next;
			curNode.next = null;
		}
		return dummy.next;
	}
}
