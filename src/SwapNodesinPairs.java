public class SwapNodesinPairs {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     * time : o(n) space : o(n)
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = swapPairs(next.next);
        head.next = newHead;
        next.next = head;
        return next;
    }
}
