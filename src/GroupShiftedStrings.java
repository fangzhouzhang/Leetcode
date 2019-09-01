import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str: strings) {
			String key = "";
			for (int i = 1; i < str.length(); i++) {
				int offset = str.charAt(i) - str.charAt(i - 1);
				key += offset > 0? offset : offset + 26;
			}
			map.putIfAbsent(key, new ArrayList<String>());
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
