import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
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
		dfs(res, word, 0, 0, "");
		return res;
	}
	private void dfs(List<String> res,
					 String word,
					 int level,
					 int count,
					 String temp) {
		if (level == word.length() && count == 0) {
			res.add(new String(temp));
			return;
		} else if (level == word.length() && count != 0) {
			res.add(new String(temp + count));
			return;
		}
		char ch = word.charAt(level);
		if (count == 0) {
			dfs(res, word, level + 1, count, temp + ch);
		} else {//count > 0
			dfs(res, word, level + 1, 0, temp + count + ch);
		}

		dfs(res, word, level + 1, count + 1, temp);
	}
}
