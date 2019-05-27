public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (s.length() == 0 && p.length() == 0 || s.equals(p)) {
			return true;
		}
		Boolean[][] mem = new Boolean[s.length()][p.length()];
		return dfs(s, 0, p, 0, mem);
	}
	private boolean dfs(String s, int idxs, String p, int idxp, Boolean[][] mem) {
		if (idxp == p.length()) {
			return idxs == s.length();
		}

		if (idxs == s.length()) {
			while (idxp < p.length()) {
				if (p.charAt(idxp) != '*') {
					return false;
				}
				idxp++;
			}
			return true;
		}


		if (idxs < s.length() && mem[idxs][idxp] != null) {
			return mem[idxs][idxp];
		}


		char ch = p.charAt(idxp);
		if (ch != '*') {
			//char or '?'
			if (idxs < s.length() && (ch == '?' || ch == s.charAt(idxs))) {
				return dfs(s, idxs + 1, p, idxp + 1, mem);
			} else {
				mem[idxs][idxp] = false;
				return false;
			}
		} else {
			//cur char is '*'
			for (int i = idxs - 1; i < s.length(); i++) {
				if (dfs(s, i + 1, p, idxp + 1, mem)) {
					mem[idxs][idxp] = true;
					return true;
				}
			}
			mem[idxs][idxp] = false;
			return false;
		}
	}
}
