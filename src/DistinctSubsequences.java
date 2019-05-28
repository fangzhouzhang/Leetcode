public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (t.length() == 0) {
			return 1;
		}
		Integer[][] mem = new Integer[s.length()][t.length()];
		return dfs(s, 0, t, 0, mem);
	}
	private int dfs(String s, int idxs, String t, int idxt, Integer[][] mem) {
		if (idxt == t.length()) {
			return 1;
		}
		if (idxs == s.length()) {
			return 0;
		}

		if (mem[idxs][idxt] != null) {
			return mem[idxs][idxt];
		}
		int sum = 0;
		for (int i = idxs; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(idxt)) {
				continue;
			}
			sum += dfs(s, i + 1, t, idxt + 1, mem);
		}
		mem[idxs][idxt] = sum;
		return mem[idxs][idxt];
	}
}
