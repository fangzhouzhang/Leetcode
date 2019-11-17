import java.util.Stack;

public class _394DecodeString {
	public String decodeString(String s) {
		if (s.length() == 0) {
			return "";
		}
		Stack<StringBuilder> ss = new Stack<>();
		ss.push(new StringBuilder());
		Stack<Integer> ns = new Stack<>();
		int val = 0;
		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				val = val * 10 + c - '0';
			} else if (c == '[') {
				ns.push(val);
				val = 0;
				ss.push(new StringBuilder());
			} else if (c == ']') {
				StringBuilder com = new StringBuilder();
				int count = ns.pop();
				String str = new String(ss.pop());
				for (int i = 0; i < count; i++) {
					com.append(str);
				}
				ss.peek().append(com);
			} else {
				//character
				ss.peek().append(c);
			}
		}
		return new String(ss.peek());
	}

	public String decodeString1(String s) {
		if (s.length() == 0) return "";
		Stack<Integer> numStack = new Stack<>();
		Stack<StringBuilder> sbStack = new Stack<>();
		sbStack.push(new StringBuilder());
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int val = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					val = val * 10 + (s.charAt(i) - '0');
					i++;
				}
				numStack.push(val);
			} else if (c == '[') {
				sbStack.push(new StringBuilder());
				i++;
			} else if (c == ']') {
				int n = numStack.pop();
				StringBuilder sb = sbStack.pop();
				for (int k = 0; k < n; k++) {
					sbStack.peek().append(sb);
				}
				i++;
			} else {
				sbStack.peek().append(c);
				i++;
			}
		}
		return sbStack.peek().toString();
	}
}
