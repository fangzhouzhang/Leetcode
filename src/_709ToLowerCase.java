public class _709ToLowerCase {
	public String toLowerCase(String str) {
		if (str == null || str.length() == 0) return str;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = Character.toLowerCase(str.charAt(i));
			sb.append(c);
		}
		return new String(sb);
	}
}
