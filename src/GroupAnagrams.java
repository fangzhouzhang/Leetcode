import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<List<String>>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String input : strs) {
			String key = encode(input);
			if (map.containsKey(key)) {
				List<String> list = map.get(key);
				list.add(input);
				map.put(key, list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(input);
				map.put(key, list);
			}
		}
		return new ArrayList<>(map.values());
	}
	private String encode(String input) {
		StringBuilder sb = new StringBuilder("00000000000000000000000000");
		for (int i = 0; i < input.length(); i++) {
			int idx = input.charAt(i) - 'a';
			sb.setCharAt(idx, (char)(sb.charAt(idx) + 1));
		}
		return new String(sb);
	}
}
