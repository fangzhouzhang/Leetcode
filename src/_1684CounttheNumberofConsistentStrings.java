import java.util.HashSet;
import java.util.Set;

public class _1684CounttheNumberofConsistentStrings {
	public int countConsistentStrings(String allowed, String[] words) {
		int res = 0;
		Set<Character> set = new HashSet<>();
		for (char c : allowed.toCharArray()) set.add(c);
		for (String word : words) {
			boolean valid = true;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!set.contains(c)) {
					valid = false;
					break;
				}
			}
			if (valid) res++;
		}
		return res;
	}
}
