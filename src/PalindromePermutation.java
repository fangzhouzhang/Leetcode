import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Map<Character, Integer> map = new HashMap<>();
		int single = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
			if (map.get(ch) % 2 != 0) {
				single++;
			} else {
				single--;
			}
		}
		return single <= 1 ? true : false;
	}
}
