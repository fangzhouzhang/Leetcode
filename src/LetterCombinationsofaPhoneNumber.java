import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	public String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	/**
	 * time：o(4^n) n is length of digits. space:o(n)
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return res;
		}
		helper(res, digits, 0, new StringBuilder());
		return res;
	}
	private void helper(List<String> res, String digits, int level, StringBuilder sb) {
		if (level == digits.length()) {
			res.add(new String(sb));
			return;
		}
		int digit = Integer.parseInt("" + digits.charAt(level));
		for (int i = 0; i < KEYS[digit].length(); i++) {
			sb.append(KEYS[digit].charAt(i));
			helper(res, digits, level + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
