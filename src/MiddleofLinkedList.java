public class MiddleofLinkedList {
    /*
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     * Time : O(n) Space : O(1)
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
