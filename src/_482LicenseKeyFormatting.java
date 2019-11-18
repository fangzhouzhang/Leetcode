public class _482LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
		StringBuilder rev = new StringBuilder();
		for (int i = S.length() - 1; i >= 0; i--) rev.append(S.charAt(i));
		String[] arr = rev.toString().split("-");
		StringBuilder sb = new StringBuilder();
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				if (len == K) {
					sb.append('-');
					len = 0;
				}
				char c = arr[i].charAt(j);
				if (c >= 'a' && c <= 'z') {
					c = Character.toUpperCase(c);
				}
				sb.append(c);
				len++;
			}
		}
		return new String(sb.reverse());
	}
}
