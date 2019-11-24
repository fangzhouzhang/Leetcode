import java.util.ArrayList;
import java.util.List;

public class _241DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		if (input == null || input.length() == 0) return res;
		return dfs(input, 0, input.length() - 1);
	}

	private List<Integer> dfs(String input, int start, int end) {
		List<Integer> res = new ArrayList<>();
		boolean singleNum = true;
		for (int i = start; i <= end; i++) {
			char c = input.charAt(i);
			if (c == '*' || c == '+' || c == '-') {
				singleNum = false;
				List<Integer> lefts = dfs(input, start, i - 1);
				List<Integer> rights = dfs(input, i + 1, end);
				calc(lefts, rights, res, c);
			}
		}
		if (singleNum) res.add(Integer.parseInt(input.substring(start, end + 1)));
		return res;
	}

	private void calc(List<Integer> lefts, List<Integer> rights, List<Integer> res, char c) {
		int val = 0;
		for (Integer left : lefts) {
			for (Integer right : rights) {
				if (c == '+') val = left + right;
				else if (c == '-') val = left - right;
				else val = left * right;
				res.add(val);
			}
		}
	}
}
