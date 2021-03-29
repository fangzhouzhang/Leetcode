import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1087EvaluatetheBracketPairsofaString {
	public String evaluate(String s, List<List<String>> knowledge) {
		int n = s.length();
		Map<String, String> map = new HashMap<>();
		for (List<String> k : knowledge) {
			map.put(k.get(0), k.get(1));
		}
		int idx = 0;
		StringBuilder res = new StringBuilder();
		while (idx < n) {
			StringBuilder sb = new StringBuilder();
			char c = s.charAt(idx);
			if (c == '(') {
				idx++;
				while (idx < n && s.charAt(idx) != ')') {
					sb.append(s.charAt(idx));
					idx++;
				}
				String key = sb.toString();
				String val = map.get(key);
				if (null == val) {
					res.append('?');
				} else res.append(val);
				idx++;
			} else {
				res.append(c);
				idx++;
			}
		}
		return res.toString();
	}
}
