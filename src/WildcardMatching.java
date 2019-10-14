public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int sIdx = 0;
		int pIdx = 0;
		int sTmp = 0;
		int starIdx = -1;
		while (sIdx < s.length()) {
			if (pIdx < p.length() && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '?')) {
				sIdx++;
				pIdx++;
			} else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
				starIdx = pIdx;
				sTmp = sIdx;
				pIdx++;
			} else if (starIdx != -1) {
				sIdx = sTmp + 1;
				sTmp = sIdx;
				pIdx = starIdx + 1;
			} else {
				return false;
			}
		}
		while (pIdx < p.length() && p.charAt(pIdx) == '*') {
			pIdx++;
		}
		return pIdx == p.length();
	}
}
