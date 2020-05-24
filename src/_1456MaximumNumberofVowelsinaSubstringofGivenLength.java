import java.util.HashSet;
import java.util.Set;

public class _1456MaximumNumberofVowelsinaSubstringofGivenLength {
	public int maxVowels(String s, int k) {
		if (s == null || s.length() == 0) return 0;
		int start = 0, end = 0;
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		int res = 0, cur = 0;
		while (end < s.length()) {
			if (set.contains(s.charAt(end))) cur++;
			if (end - start + 1 > k) {
				if (set.contains(s.charAt(start))) cur--;
				start++;
			}
			res = Math.max(res, cur);
			end++;
		}
		return res;
	}
}
