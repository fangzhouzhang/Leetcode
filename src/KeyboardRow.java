import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeyboardRow {
	public String[] findWords(String[] words) {
		String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			for (char c: strs[i].toCharArray()) {
				map.put(c, i);
			}
		}
		List<String> res = new ArrayList<>();
		for (String w: words) {
			if (w.equals("")) continue;
			int idx = map.get(w.toUpperCase().charAt(0));
			for (char c : w.toUpperCase().toCharArray()) {
				if (idx != map.get(c)) {
					idx = -1;
					break;
				}
			}
			if (idx != -1) {
				res.add(w);
			}
		}
		String[] ans = new String[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}
}
