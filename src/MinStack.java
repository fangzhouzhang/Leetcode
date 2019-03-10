import java.util.Stack;

public class MinStack {
    //Time : O(1) both push and pop Space: O(n)
	private Stack<Pair> stack;
	private Stack<Pair> min;
	private int idx;
	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		min = new Stack<>();
		idx = 0;
	}

	public void push(int x) {
		// idx++;
		stack.add(new Pair(x, idx));

		if (min.size() == 0) {
			min.add(new Pair(x, idx));
		} else {//
			if (x < min.peek().val) {
				min.add(new Pair(x, idx));
			}
		}
		idx++;
	}

	public void pop() {
		int num = stack.pop().val;
		if (num == min.peek().val && idx == min.peek().idx) {
			min.pop();
		}
		idx--;
	}

	public int top() {
		return stack.peek().val;
	}

	public int getMin() {
		return min.peek().val;
	}
	private class Pair{
		private int val;
		private int idx;
		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}
}
