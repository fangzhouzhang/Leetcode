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
		if (word == null || word.length() == 0) {
			res.add("");
			return res;
		}
		StringBuilder sb = new StringBuilder();
		dfs(res, sb, 0, 0, word);
		return res;
	}

	private void dfs(List<String> res, StringBuilder sb, int idx, int number, String word) {
		if (idx == word.length()) {
			if (number != 0) {
				int len = sb.length();
				sb.append(number);
				res.add(new String(sb));
				sb.setLength(len);
			} else {
				res.add(new String(sb));
			}
			return;
		}
		//add number
		dfs(res, sb, idx + 1, number + 1, word);
		//add char
		int len = sb.length();
		if (number != 0) sb.append(number);
		sb.append(word.charAt(idx));
		dfs(res, sb, idx + 1, 0, word);
		sb.setLength(len);

	}
}
