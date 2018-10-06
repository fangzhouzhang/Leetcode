public class LongestCommonPrefix {
	/**
	 * for every str in strs, minLen is minimum length of that string, size is number of strings in strings
	 * time: o(minLen * size) space: (minLen)
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			minLen = Math.min(minLen, strs[i].length());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < minLen; i++) {
			char ch = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (ch != strs[j].charAt(i)) {
					return sb.toString();
				}
			}
			sb.append(ch);
		}
		return sb.toString();
	}
}
