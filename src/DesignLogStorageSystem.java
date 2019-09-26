import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignLogStorageSystem {
	List<String[]> list;
	int[] indices = new int[]{4,7,10,13,16,19};
	Map<String, Integer> map;
	public DesignLogStorageSystem() {
		list = new ArrayList<>();
		map = new HashMap<>();
		map.put("Year", 0);
		map.put("Month", 1);
		map.put("Day", 2);
		map.put("Hour", 3);
		map.put("Minute", 4);
		map.put("Second", 5);
	}

	public void put(int id, String timestamp) {
		String[] tmp = new String[]{id + "", timestamp};
		list.add(tmp);
	}

	public List<Integer> retrieve(String s, String e, String gra) {
		Integer idx = indices[map.get(gra)];
		List<Integer> ids = new ArrayList<>();
		if (idx != null) {
			for (String[] a : list) {
				if (a[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 && a[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0) {
					ids.add(Integer.valueOf(a[0]));
				}
			}
		}
		return ids;
	}
}
