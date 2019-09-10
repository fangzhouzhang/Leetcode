public class FindtheDifference {
	public char findTheDifference(String s, String t) {
		char res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			res ^= c;
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			res ^= c;
		}
		return res;
	}
}
