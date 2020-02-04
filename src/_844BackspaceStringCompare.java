import java.util.Stack;

public class _844BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		if (S == null && T == null) return true;
		if (S == null || T == null) return false;
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		addChar(s1, S);
		addChar(s2, T);
		if (s1.size() != s2.size()) return false;
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (s1.pop() != s2.pop()) return false;
		}
		return true;
	}

	private void addChar(Stack<Character> s, String t) {
		for (char c: t.toCharArray()) {
			if (c != '#') s.add(c);
			else if (c == '#' && !s.isEmpty()) s.pop();
		}
	}
}
