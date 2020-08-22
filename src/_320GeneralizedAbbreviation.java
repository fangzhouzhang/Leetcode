import java.util.ArrayList;
import java.util.List;

public class _320GeneralizedAbbreviation {
	/**
	 * time: o(2^n) space: o(n)
	 * @param word
	 * @return
	 */
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		if (word == null) return res;
		if (word.length() == 0) {
			res.add("");
			return res;
		}
		dfs(word, 0, 0, new StringBuilder(), res);
		return res;
	}

	private void dfs(String word, int idx, int number, StringBuilder sb, List<String> res) {
		if (idx == word.length()) {
			int prev = sb.length();
			if (number != 0) sb.append(number);
			res.add(new String(sb));
			sb.setLength(prev);
			return;
		}
		//add character
		int prev = sb.length();
		if (number != 0) sb.append(number);
		sb.append(word.charAt(idx));
		dfs(word, idx + 1, 0, sb, res);
		sb.setLength(prev);

		//add one number
		dfs(word, idx + 1, number + 1, sb, res);
	}
}
