public class PartitionList {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     * time : o(n) space : o(1)
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode l1 = new ListNode(-1);
        ListNode tail1 = l1;
        ListNode l2 = new ListNode(-1);
        ListNode tail2 = l2;
        while (head != null) {
            if (head.val < x) {
                tail1.next = head;
                tail1 = tail1.next;
            } else {
                tail2.next = head;
                tail2 = tail2.next;
            }
            head = head.next;
        }
        tail1.next = null;
        tail2.next = null;
        tail1.next = l2.next;
        return l1.next;

    }
}
