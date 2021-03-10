import java.util.Stack;

public class _682BaseballGame {
	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		for (String op : ops) {
			if (op.equals("C")) {
				stack.pop();
			} else if (op.equals("D")) {
				int val = stack.peek();
				stack.push(val * 2);
			} else if (op.equals("+")) {
				int b = stack.pop();
				int a = stack.pop();
				int res = a + b;
				stack.push(a);
				stack.push(b);
				stack.push(res);
			} else {
				int val = Integer.valueOf(op);
				stack.push(val);
			}
		}
		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
}
