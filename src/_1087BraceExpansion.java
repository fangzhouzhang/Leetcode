import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1087BraceExpansion {
	public String[] expand(String S) {
		if (S == null || S.length() == 0) return new String[0];
		//deal with {}
		char[] arr = S.toCharArray();
		int idx = 0;
		List<String> list = new ArrayList<>();
		while (idx < arr.length) {
			if (arr[idx] == '{') {
				int j = idx + 1;
				StringBuilder sb = new StringBuilder();
				while (j < arr.length && arr[j] != '}') {
					if (arr[j] == ',') j++;
					else if (Character.isLetter(arr[j])) {
						sb.append(arr[j]);
						j++;
					}
				}
				list.add(new String(sb));
				idx = j + 1;
			} else if (Character.isLetter(arr[idx])) {
				list.add(arr[idx] + "");
				idx++;
			}
		}
		List<String> res = new ArrayList<>();
		dfs(list, 0, res, new StringBuilder());
		Collections.sort(res);
		String[] ans = new String[res.size()];
		int k = 0;
		for (String s : res) ans[k++] = s;
		return ans;
	}

	private void dfs(List<String> list, int idx, List<String> res, StringBuilder sb) {
		if (idx == list.size()) {
			res.add(new String(sb));
			return;
		}
		String cur = list.get(idx);
		for (int i = 0; i < cur.length(); i++) {
			char c = cur.charAt(i);
			sb.append(c);
			dfs(list, idx + 1, res, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
