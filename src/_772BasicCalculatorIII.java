import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _772BasicCalculatorIII {
	public int calculate(String s) {
		if (s == null || s.length() == 0) return 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c == '+' || c == '-') && (i == 0 || s.charAt(i - 1) == '(')) {
				sb.append(0);
			}
			sb.append(c);
		}
		s = sb.toString();
		Map<Character, Integer> map = new HashMap<>();
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('$', 0);
		int i = 0;
		Stack<Integer> numStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int val = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					val = val * 10 + (s.charAt(i) - '0');
					i++;
				}
				numStack.push(val);
			} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
				addOp(c, numStack, opStack, map);
				i++;
			} else {
				//c == ' '
				i++;
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
				if (opStack.peek() == '(') {
					opStack.pop();
					break;
				}
				int num2 = numStack.pop();
				int num1 = numStack.pop();
				char op = opStack.pop();
				numStack.push(cal(op, num1, num2));
			}
		} else {
			while (!opStack.isEmpty()) {
				char prevOp = opStack.peek();
				if (map.get(prevOp) != null && map.get(prevOp) >= map.get(c)) {
					int num2 = numStack.pop();
					int num1 = numStack.pop();
					char op = opStack.pop();
					numStack.push(cal(op, num1, num2));
				} else break;
			}
			opStack.push(c);
		}
	}

	private int cal(char c, int a, int b) {
		if (c == '+') return a + b;
		else if (c == '-') return a - b;
		else if (c == '*') return a * b;
		else return a / b;
	}
}

