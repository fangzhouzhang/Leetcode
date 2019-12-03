import java.util.Stack;

public class _155MinStack {
    //Time : O(1) both push and pop Space: O(n)
	private class MinStack {
		private int min = Integer.MAX_VALUE;
		private Stack<Integer> stack;
		/** initialize your data structure here. */
		public MinStack() {
			stack = new Stack<>();
		}

		public void push(int x) {
			if (x <= min) {
				stack.push(min);
				min = x;
			}
			stack.push(x);
		}

		public void pop() {
			if (stack.pop() == min) min = stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return min;
		}
	}
}
