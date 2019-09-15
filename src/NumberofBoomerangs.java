import java.util.HashMap;
import java.util.Map;

public class NumberofBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		if (points.length == 0 || points[0].length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Long,Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				long x = (long)points[i][0] - (long)points[j][0];
				long y = (long)points[i][1] - (long)points[j][1];
				long distance = x * x + y * y;
				if (map.containsKey(distance)) {
					map.put(distance, map.get(distance) + 1);
				} else {
					map.put(distance, 1);
				}
			}
			for (Map.Entry<Long, Integer> e : map.entrySet()) {
				res += e.getValue() * (e.getValue() - 1);
			}
		}
		return res;
	}
}
