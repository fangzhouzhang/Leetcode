import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _227BasicCalculatorII {
	public int calculate(String s) {
		if (s == null || s.length() == 0) return 0;
		s = s.trim();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c == '+' || c == '-') && (i == 0 || s.charAt(i - 1) == '(')) sb.append('0');
			if (c != ' ') sb.append(c);
		}
		s = new String(sb);
		Stack<Integer> nums = new Stack<>();
		Stack<Character> ops = new Stack<>();
		Map<Character, Integer> map = new HashMap<>();
		map.put('$', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		int idx = 0;
		while (idx < s.length()) {
			char c = s.charAt(idx);
			if (Character.isDigit(c)) {
				int val = 0;
				while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
					val = val * 10 + s.charAt(idx) - '0';
					idx++;
				}
				nums.push(val);
			} else {
				addOp(c, nums, ops, map);
				idx++;
			}
		}
		addOp('$', nums, ops, map);
		return nums.peek();
	}

	private void addOp(char c, Stack<Integer> nums, Stack<Character> ops, Map<Character, Integer> map) {
		if (c == '(') ops.push(c);
		else if (c == ')') {
			while (!ops.isEmpty()) {
				if (ops.peek() == '(') {
					ops.pop();
					break;
				}
				int b = nums.pop();
				int a = nums.pop();
				char op = ops.pop();
				int num = calc(op, a, b);
				nums.push(num);
			}
		} else {
			while (!ops.isEmpty()) {
				if (map.get(ops.peek()) == null || map.get(ops.peek()) < map.get(c)) break;
				int b = nums.pop();
				int a = nums.pop();
				char op = ops.pop();
				int num = calc(op, a, b);
				nums.push(num);
			}
			ops.push(c);
		}
	}

	private int calc(char c, int a, int b) {
		if (c == '+') return a + b;
		else if (c == '-') return a - b;
		else if (c == '*') return a * b;
		else return a / b;
	}
}
