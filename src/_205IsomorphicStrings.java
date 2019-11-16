import java.util.HashMap;
import java.util.Map;

public class _205IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		Map<Character, Character> map2 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (isValid(map, a, b) && isValid(map2, b, a)) continue;
			else return false;
		}
		return true;
	}

	private boolean isValid(Map<Character, Character> map, char a, char b) {
		if (map.containsKey(a)) {
			if (map.get(a) != b) return false;
		} else {
			map.put(a, b);
		}
		return true;
	}
}
