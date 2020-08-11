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
		if (s == null || s.length() == 0) return s;
		Stack<Integer> nums = new Stack<>();
		Stack<StringBuilder> sbs = new Stack<>();
		sbs.push(new StringBuilder());
		int idx = 0;
		while (idx < s.length()) {
			char c = s.charAt(idx);
			if (Character.isDigit(c)) {
				int val = 0;
				while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
					val = val * 10 + (s.charAt(idx) - '0');
					idx++;
				}
				nums.push(val);
			} else if (c == '[') {
				sbs.push(new StringBuilder());
				idx++;
			} else if (c == ']') {
				StringBuilder sb = sbs.pop();
				int n = nums.pop();
				for (int i = 0; i < n; i++) {
					sbs.peek().append(sb);
				}
				idx++;
			} else {
				sbs.peek().append(c);
				idx++;
			}
		}
		return sbs.peek().toString();
	}
}
