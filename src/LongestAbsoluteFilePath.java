import java.util.Stack;

public class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
		if (input.length() == 0) return 0;
		String[] arr = input.split("\n");
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int max = 0;
		for (String s: arr) {
			int lev = s.lastIndexOf("\t") + 1;
			int curLevel = lev + 1;
			while (curLevel < stack.size()) {
				stack.pop();
			}
			boolean isFile = false;
			if (s.contains(".")) isFile = true;

			if (isFile) {
				max = Math.max(max, stack.peek() + (s.length() - lev));
			} else {
				int tmp = stack.peek() + ((s.length() - lev)) + 1;
				stack.push(tmp);
			}
		}
		return max;
	}
}
