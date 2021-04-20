import java.util.ArrayList;
import java.util.List;

public class _784LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<>();
		dfs(res, S, 0, new StringBuilder());
		return res;
	}

	private void dfs(List<String> res, String s, int idx, StringBuilder sb) {
		if (idx == s.length()) {
			res.add(new String(sb));
			return;
		}

		char cur = s.charAt(idx);

		if (Character.isLetter(cur)) {
			// add CAPS
			sb.append(Character.toLowerCase(cur));
			dfs(res, s, idx + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
			//
			sb.append(Character.toUpperCase(cur));
			dfs(res, s, idx + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		} else {
			sb.append(cur);
			dfs(res, s, idx + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
