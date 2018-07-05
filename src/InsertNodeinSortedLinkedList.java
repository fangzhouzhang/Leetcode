public class InsertNodeinSortedLinkedList {
    /**
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     * Time : O(n) Space: O(1)
     */
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
        ListNode node = new ListNode(val);
        if (head == null) {
            node.next = head;
            return node;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        //judge head val
        if (head.val > val) {
            dummy.next = node;
            node.next = head;
            return dummy.next;
        }
        while (cur != null && cur.next != null) {
            if (cur.val <= val && cur.next.val >= val) {
                node.next = cur.next;
                cur.next = node;
                return dummy.next;
            }
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = node;
        }
        return dummy.next;
    }
}

