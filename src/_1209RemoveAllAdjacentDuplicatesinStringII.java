import java.util.Stack;

public class _1209RemoveAllAdjacentDuplicatesinStringII {
	public String removeDuplicates(String s, int k) {
		Stack<Pair> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty() || stack.peek().c != c) {
				stack.push(new Pair(1, c));
			} else {
				Pair p = stack.peek();
				p.freq++;
			}
			if (!stack.isEmpty() && stack.peek().freq == k) stack.pop();
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			Pair p = stack.pop();
			for (int i = 0; i < p.freq; i++) sb.append(p.c);
		}
		return new String(sb.reverse());
	}

	private class Pair {
		int freq;
		char c;
		public Pair(int f, char c) {
			this.freq = f;
			this.c = c;
		}
	}
}
