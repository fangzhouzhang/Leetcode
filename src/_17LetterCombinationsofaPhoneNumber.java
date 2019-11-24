import java.util.ArrayList;
import java.util.List;

public class _17LetterCombinationsofaPhoneNumber {
	/**
	 * time：o(4^n) n is length of digits. space:o(n)
	 * @param digits
	 * @return
	 */
	private String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) return res;
		dfs(digits, 0, res, new StringBuilder());
		return res;
	}

	private void dfs(String digits, int idx, List<String> res, StringBuilder sb) {
		if (idx == digits.length()) {
			res.add(new String(sb));
			return;
		}
		int key = digits.charAt(idx) - '0';
		for (int i = 0; i < KEYS[key].length(); i++) {
			sb.append(KEYS[key].charAt(i));
			dfs(digits, idx + 1, res, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
