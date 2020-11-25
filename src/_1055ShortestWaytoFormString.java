public class _1055ShortestWaytoFormString {
	public int shortestWay(String source, String target) {
		int m = source.length();
		char[] ss = source.toCharArray();
		char[] ts = target.toCharArray();
		Integer[][] next = new Integer[m][26];
		next[m - 1][ss[m - 1] - 'a'] = 0;
		for (int i = m - 2; i >= 0; i--) {
			for (int k = 0; k < 26; k++) {
				next[i][k] = next[i + 1][k];
			}
			next[i][ss[i] - 'a'] = i + 1;
		}
		int res = 0, j = 0;
		Integer i = 0;
		while (j < ts.length) {
			if (next[0][ts[j] - 'a'] == null) return -1;
			i = next[i][ts[j] - 'a'];
			if (i == null) {
				res++;
				i = 0;
				continue;
			}
			if (i == 0) {
				res++;
				j++;
			} else {
				j++;
			}
		}
		return i == 0 ? res : res + 1;
	}
}
