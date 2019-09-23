import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
	public List<String> subdomainVisits(String[] cpdomains) {
		List<String> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String s : cpdomains) {
			String[] a = s.split(" ");
			int fre = Integer.valueOf(a[0]);
			String[] b = a[1].split("\\.");
			for (int i = 0; i < b.length; i++) {
				String key = "";
				for (int j = i; j < b.length; j++) {
					if (j != b.length - 1) {
						key += b[j] + ".";
					} else {
						key += b[j];
					}
				}
				map.put(key, map.getOrDefault(key, 0) + fre);
			}
		}
		for (Map.Entry<String, Integer> e: map.entrySet()) {
			String tmp = e.getValue() + " " + e.getKey();
			res.add(tmp);
		}
		return res;
	}
}
