import java.util.HashSet;
import java.util.Set;

public class _1805NumberofDifferentIntegersinaString {
	public int numDifferentIntegers(String word) {
		int n = word.length();
		Set<Integer> set = new HashSet<>();
		int idx = 0;
		while (idx < n) {
			if (!Character.isDigit(word.charAt(idx))) {
				idx++;
				continue;
			}
			int val = 0;
			while (idx < n && Character.isDigit(word.charAt(idx))) {
				val = val * 10 + word.charAt(idx) - '0';
				idx++;
			}
			set.add(val);
		}
		return set.size();
	}
}
