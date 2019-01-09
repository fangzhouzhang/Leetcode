import java.util.Stack;

public class ImplementQueueusingStacks {
	class MyQueue {
		private Stack<Integer> s1;
		private Stack<Integer> s2;
		/** Initialize your data structure here. */
		public MyQueue() {
			s1 = new Stack<>();
			s2 = new Stack<>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			s1.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.pop();
		}

		/** Get the front element. */
		public int peek() {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			return s1.isEmpty();
		}
	}

}