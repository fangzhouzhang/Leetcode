import java.util.ArrayList;
import java.util.List;

public class _241DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		if (input == null || input.length() == 0) return res;
		return dfs(input, 0, input.length() - 1);
	}

	private List<Integer> dfs(String a, int start, int end) {
		List<Integer> res = new ArrayList<>();
		boolean singleNum = true;
		for (int i = start; i <= end; i++) {
			char c = a.charAt(i);
			if (!Character.isDigit(c)) {
				singleNum = false;
				List<Integer> left = dfs(a, start, i - 1);
				List<Integer> right = dfs(a, i + 1, end);
				getResult(left, right, res, c);
			}
		}
		if (singleNum) res.add(Integer.valueOf(a.substring(start, end + 1)));
		return res;
	}

	private void getResult(List<Integer> a, List<Integer> b, List<Integer> res, char c) {
		for (int a1 : a) {
			for (int b1 : b) {
				res.add(calc(a1, b1, c));
			}
		}
	}

	private int calc(int a, int b, char c) {
		if (c == '+') return a + b;
		else if (c == '-') return a - b;
		else return a * b;
	}
}
