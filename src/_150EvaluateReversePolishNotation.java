import java.util.Stack;

public class _150EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		for (String s : tokens) {
			if (s.equals("+")) stack.push(stack.pop() + stack.pop());
			else if (s.equals("-")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
			}
			else if (s.equals("*")) stack.push(stack.pop() * stack.pop());
			else if (s.equals("/"))  {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
			}
			else stack.push(Integer.valueOf(s));
		}
		return stack.peek();
	}
}
