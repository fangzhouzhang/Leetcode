public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		int idx1 = 0, idx2 = 0;
		while (idx1 < version1.length() || idx2 < version2.length()) {
			int tmp1 = 0;
			int tmp2 = 0;
			while (idx1 < version1.length() && version1.charAt(idx1) != '.') {
				tmp1 = tmp1 * 10 + version1.charAt(idx1) - '0';
				idx1++;
			}
			while (idx2 < version2.length() && version2.charAt(idx2) != '.') {
				tmp2 = tmp2 * 10 + version2.charAt(idx2) - '0';
				idx2++;
			}
			if (tmp1 < tmp2) {
				return -1;
			} else if (tmp1 > tmp2) {
				return 1;
			} else {
				idx1++;
				idx2++;
			}
		}
		return 0;
	}
}
