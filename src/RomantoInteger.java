import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
	/**
	 * n is length of string
	 * time: o(n) space: o(1)
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		Map<Character, Integer> map = buildMap();
		if (s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return map.get(s.charAt(0));
		}
		int slow = 0;
		int fast = 1;
		int sum = 0;
		while (fast < s.length()) {
			if (map.get(s.charAt(slow)) >= map.get(s.charAt(fast))) {
				sum += map.get(s.charAt(slow));
				slow++;
				fast++;
			} else {
				sum += map.get(s.charAt(fast)) - map.get(s.charAt(slow));
				slow += 2;
				fast += 2;
			}
		}
		if (slow < s.length()) {
			sum += map.get(s.charAt(slow));
		}
		return sum;
	}
	private Map<Character, Integer> buildMap() {
		Map<Character, Integer> map = new HashMap<>();
		/**
		 Symbol       Value
		 I             1
		 V             5
		 X             10
		 L             50
		 C             100
		 D             500
		 M             1000
		 **/
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		return map;
	}
}
