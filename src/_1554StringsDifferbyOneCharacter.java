import java.util.HashSet;
import java.util.Set;

public class _1554StringsDifferbyOneCharacter {
	public boolean differByOne(String[] dict) {
		if (dict == null || dict.length == 0) return false;
		Set<String> set = new HashSet<>();
		int n = dict[0].length();
		for (int i = 0; i < n; i++) {
			set.clear();
			for (String w : dict) {
				String word = w.substring(0, i) + w.substring(i + 1);
				if (set.contains(word)) return true;
				set.add(word);
			}
		}
		return false;
	}
}
