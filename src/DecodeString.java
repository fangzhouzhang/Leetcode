import java.util.Stack;

public class DecodeString {
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
}
