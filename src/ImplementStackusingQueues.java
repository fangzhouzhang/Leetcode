import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
	class MyStack {
		private Queue<Integer> q1;
		private Queue<Integer> q2;
		/** Initialize your data structure here. */
		public MyStack() {
			q1 = new LinkedList<>();
			q2 = new LinkedList<>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			while (!q2.isEmpty()) {
				q1.add(q2.poll());
			}
			q1.add(x);
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			while (!q1.isEmpty()) {
				q2.add(q1.poll());
			}
			while (!q2.isEmpty()) {
				q1.add(q2.poll());
			}
			while (q1.size() > 1) {
				q2.add(q1.poll());
			}
			return q1.poll();
		}

		/** Get the top element. */
		public int top() {
			while (!q1.isEmpty()) {
				q2.add(q1.poll());
			}
			while (!q2.isEmpty()) {
				q1.add(q2.poll());
			}
			while (q1.size() > 1) {
				q2.add(q1.poll());
			}
			return q1.peek();
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			while (!q2.isEmpty()) {
				q1.add(q2.poll());
			}
			return q1.isEmpty();
		}
	}

}
