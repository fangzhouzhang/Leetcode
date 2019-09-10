import java.util.Random;

public class LinkedListRandomNode {
	private Random rand;
	private int len;
	private ListNode head;
	/** @param head The linked list's head.
	Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode(ListNode head) {
		rand = new Random();
		this.head = head;
		ListNode cur = head;
		int tmp = 0;
		while (cur != null) {
			tmp++;
			cur = cur.next;
		}
		this.len = tmp;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int idx = rand.nextInt(len);
		ListNode cur = head;
		while (idx != 0) {
			idx--;
			cur = cur.next;
		}
		return cur.val;
	}
}
