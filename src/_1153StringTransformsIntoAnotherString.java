import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _1153StringTransformsIntoAnotherString {
	public boolean canConvert(String str1, String str2) {
		if (str1 == null && str2 == null) return true;
		if (str1 == null || str2 == null) return false;
		if (str1.length() != str2.length()) return false;
		if (str1.equals(str2)) return true;
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			char a = str1.charAt(i);
			char b = str2.charAt(i);
			// if (a == b) continue;
			if (map.containsKey(a) && map.get(a) != b) return false;
			else if (!map.containsKey(a)) map.put(a, b);
		}
		return new HashSet<Character>(map.values()).size() < 26;
	}
}
