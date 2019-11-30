import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0) return res;
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String key = encode(str);
			if (!map.containsKey(key)) map.put(key, new ArrayList<>());
			map.get(key).add(str);
		}
		for (Map.Entry<String, List<String>> e : map.entrySet()) res.add(e.getValue());
		return res;
	}

	private String encode(String s) {
		StringBuilder sb = new StringBuilder("00000000000000000000000000");
		for (char c : s.toCharArray()) {
			int idx = (int)(c - 'a');
			sb.setCharAt(idx, (char)(sb.charAt(idx) + 1));
		}
		return new String(sb);
	}
}
