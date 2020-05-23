import java.util.ArrayList;
import java.util.List;

public class _155MinStack {
    //Time : O(1) both push and pop Space: O(n)
	class MinStack {
		List<Pair> stack;
		Integer min;
		/** initialize your data structure here. */
		public MinStack() {
			stack = new ArrayList<>();
			min = null;
		}

		public void push(int x) {
			if (null == min) min = x;
			else min = Math.min(min, x);
			stack.add(new Pair(x, min));
		}

		public void pop() {
			stack.remove(stack.size() - 1);
			if (stack.size() > 0) min = getMin();
			else min = null;
		}

		public int top() {
			return stack.get(stack.size() - 1).val;
		}

		public int getMin() {
			return stack.get(stack.size() - 1).min;
		}
	}
	class Pair {
		public int val;
		public int min;
		public Pair(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}
}
