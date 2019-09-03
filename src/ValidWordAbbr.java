import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {
	private final Map<String, Set<String>> map;
	public ValidWordAbbr(String[] dictionary) {
		map = new HashMap<>();
		for (String str : dictionary) {
			String key = getAbbr(str);
			if (map.containsKey(key)) {
				Set<String> set = map.get(key);
				set.add(str);
			} else {
				Set<String> set = new HashSet<>();
				set.add(str);
				map.put(key, set);
			}
		}
	}

	public boolean isUnique(String word) {
		String abbr = getAbbr(word);
		Set<String> set = map.get(abbr);
		return set == null || (set.contains(word) && set.size() == 1);
	}

	private String getAbbr(String word) {
		if (word.length() <= 2) {
			return word;
		}
		char first = word.charAt(0);
		char last = word.charAt(word.length() - 1);
		int number = word.length() - 2;
		return "" + first + number + last;
	}
}
