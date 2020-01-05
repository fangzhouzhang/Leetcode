import java.util.Stack;

public class _1309DecryptStringfromAlphabettoIntegerMapping {
	public String freqAlphabets(String s) {
		if (s == null || s.length() == 0) return s;
		Stack<Integer> stack = new Stack<>();
		int i = s.length() - 1;
		while (i >= 0) {
			char c  = s.charAt(i);
			if (Character.isDigit(c)) {
				stack.push((int)(c - '0'));
				i--;
			} else {
				stack.push(Integer.valueOf(s.substring(i - 2, i)));
				i -= 3;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) sb.append((char)(stack.pop() - 1 + 'a'));
		return new String(sb);
	}
}
