import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _224BasicCalculator {

	public int calculate(String s) {
		if (s == null || s.length() == 0) return 0;
		Stack<Integer> numStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		int idx = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put('+', 1);
		map.put('-', 1);
		map.put('$', 0);
		while (idx < s.length()) {
			char c = s.charAt(idx);
			if (Character.isDigit(c)) {
				int val = 0;
				while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
					val = val * 10 + (s.charAt(idx) - '0');
					idx++;
				}
				numStack.push(val);
			} else if (c == '(' || c == ')' || c == '-' || c == '+') {
				addOp(c, numStack, opStack, map);
				idx++;
			} else {
				idx++;
			}
		}
		addOp('$', numStack, opStack, map);
		return numStack.peek();
	}

	private void addOp(char c, Stack<Integer> numStack, Stack<Character> opStack, Map<Character, Integer> map) {
		if (c == '(') {
			opStack.push(c);
		} else if (c == ')') {
			while (!opStack.isEmpty()) {
				char op = opStack.pop();
				if (op == '(') break;
				int b = numStack.pop();
				int a = numStack.pop();
				int val = calc(op, a, b);
				numStack.push(val);
			}
		} else {
			while (!opStack.isEmpty()) {
				char pre = opStack.peek();
				if (!map.containsKey(pre) || map.get(pre) < map.get(c)) break;
				char op = opStack.pop();
				int b = numStack.pop();
				int a = numStack.pop();
				int val = calc(op, a, b);
				numStack.push(val);
			}
			opStack.push(c);
		}
	}

	private int calc(char c, int a, int b) {
		if (c == '+') return a + b;
		else return a - b;
	}
}
