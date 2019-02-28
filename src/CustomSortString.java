import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	public String customSortString(String S, String T) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			if (map.containsKey(T.charAt(i))) {
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			} else {
				map.put(T.charAt(i), 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (map.containsKey(ch)) {
				int num = map.get(ch);
				for (int j = 0; j < num; j++) {
					sb.append(ch);
				}
				map.remove(ch);
			}
		}
		for (Character ch: map.keySet()) {
			int num = map.get(ch);
			for (int j = 0; j < num; j++) {
				sb.append(ch);
			}
			//map.remove(ch);
		}


		return sb.toString();
	}
}
