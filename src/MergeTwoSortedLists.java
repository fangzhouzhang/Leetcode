public class MergeTwoSortedLists {
    /**
     * @param node1: ListNode l1 is the head of the linked list
     * @param node2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     * time : o(n) space : o(1)
     */
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {//be careful about de-reference
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
                cur = cur.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
                cur = cur.next;
            }
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return dummy.next;

    }
}
