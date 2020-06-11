import java.util.HashMap;
import java.util.Map;

public class _246StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0) return true;
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		int i = 0, j = num.length() - 1;
		while (i <= j) {
			char a = num.charAt(i);
			char b = num.charAt(j);
			if (!map.containsKey(a) || !map.containsKey(b)) return false;
			if (map.get(a) != b) return false;
			i++;
			j--;
		}
		return true;
	}
}
