import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern.length() == 0 && str.length() == 0) {
			return true;
		}
		String[] s = str.split(" ");
		if (s.length != pattern.length()) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		Map<String, Character> map2 = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (map.containsKey(ch) && !map.get(ch).equals(s[i])) {
				return false;
			}
			if (map2.containsKey(s[i]) && map2.get(s[i]) != ch) {
				return false;
			}
			map.put(ch, s[i]);
			map2.put(s[i], ch);
		}
		return true;
	}
}
