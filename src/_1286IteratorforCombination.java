import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1286IteratorforCombination {
	private class CombinationIterator {
		private List<String> strs;
		private int idx;
		public CombinationIterator(String characters, int combinationLength) {
			idx = 0;
			strs = new ArrayList<>();
			dfs(characters.toCharArray(), combinationLength, new StringBuilder(), 0);
			Collections.sort(strs);
			// System.out.println(strs.size());
		}

		private void dfs(char[] a, int n, StringBuilder sb, int idx) {
			if (n == 0) {
				strs.add(new String(sb));
				return;
			}

			for (int i = idx; i < a.length; i++) {
				sb.append(a[i]);
				dfs(a, n - 1, sb, i + 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

		public String next() {
			if (hasNext()) return strs.get(idx++);
			return "";
		}

		public boolean hasNext() {
			return idx < strs.size() ? true : false;
		}
	}
}
