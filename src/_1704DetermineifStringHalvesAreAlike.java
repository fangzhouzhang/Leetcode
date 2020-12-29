import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1704DetermineifStringHalvesAreAlike {
	public boolean halvesAreAlike(String s) {
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		int n = s.length();
		int count = 0;
		for (int i = 0; i < n / 2; i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				count++;
			}
		}
		for (int i = n / 2; i < n; i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				count--;
			}
		}
		return count == 0;
	}
}
