import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
	/**
	 * @param head: The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		// write your code here
		if (head == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		//map.put(head, new RandomListNode(head.label));
		RandomListNode cur = head;
		while (cur != null ) {
			if (!map.containsKey(cur)) {
				map.put(cur, new RandomListNode(cur.label));
			}
			if (cur.next != null) {
				if (!map.containsKey(cur.next)) {
					map.put(cur.next, new RandomListNode(cur.next.label));
				}
				map.get(cur).next = map.get(cur.next);
			}
			if (cur.random != null) {
				if (!map.containsKey(cur.random)) {
					map.put(cur.random, new RandomListNode(cur.random.label));
				}
				map.get(cur).random = map.get(cur.random);
			}

			cur = cur.next;
		}
		return map.get(head);
	}

	private class RandomListNode {
		int label;
 	    RandomListNode next, random;
 	    RandomListNode(int x) { this.label = x; }
	}
}
