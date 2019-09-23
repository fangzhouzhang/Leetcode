import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] p = path.split(" ");
			for (int i = 1; i < p.length; i++) {
				String[] a = p[i].split("\\(");
				a[1] = a[1].replace(")", "");
				List<String> list = map.getOrDefault(a[1], new ArrayList<String>());
				String tmp = p[0] + "/" + a[0];
				list.add(tmp);
				map.put(a[1], list);
			}
		}

		for (Map.Entry<String, List<String>> e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
			if (e.getValue().size() > 1) {
				res.add(e.getValue());
			}
		}
		return res;
	}
}
