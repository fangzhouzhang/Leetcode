public class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
		if (S.length() == 0) {
			return "";
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = S.length() - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (c =='-') continue;
			if (c >= 'a' && c <= 'z') {
				sb.append((char)(c - 32));
			} else {
				sb.append(c);
			}
			if ((++cnt) % K == 0) {
				sb.append('-');
			}
		}
		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb = sb.reverse();
		return new String(sb);
	}
}
