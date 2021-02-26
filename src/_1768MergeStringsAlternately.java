public class _1768MergeStringsAlternately {
	public String mergeAlternately(String word1, String word2) {
		StringBuilder sb = new StringBuilder();
		int n = word1.length();
		int m = word2.length();
		int i = 0, j = 0, cnt = 0;
		while (i < n && j < m) {
			if (cnt % 2 == 0) {
				sb.append(word1.charAt(i++));
			} else {
				sb.append(word2.charAt(j++));
			}
			cnt++;
		}
		if (i < n) {
			sb.append(word1.substring(i));
		}
		if (j < m) {
			sb.append(word2.substring(j));
		}
		return new String(sb);
	}
}
