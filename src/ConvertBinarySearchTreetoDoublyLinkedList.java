public class ConvertBinarySearchTreetoDoublyLinkedList {
	/*
	 * @param root: The root of tree
	 * @return: the head of doubly list node
	 */
	public DoublyListNode head = null;
	public DoublyListNode prev = null;
	public DoublyListNode bstToDoublyList(TreeNode root) {
		// write your code here
		if (root == null) {
			return null;
		}
		convert(root);
		return head;
	}
	public void convert(TreeNode root) {


		if (root == null) {
			return;
		}
		convert(root.left);
		if (prev == null) {//here is start of linked list
			head = new DoublyListNode(root.val);
			prev = head;
			// return;
		} else {
			DoublyListNode newNode = new DoublyListNode(root.val);
			prev.next = newNode;
			newNode.prev = prev;
			prev = newNode;
		}


		convert(root.right);
	}

	private class DoublyListNode {
		int val;
        DoublyListNode next, prev;
        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
	}
}
