import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _963MinimumAreaRectangleII {
	public double minAreaFreeRect(int[][] points) {
		if (points == null || points.length == 0) return 0;
		double min = Double.MAX_VALUE;
		int n = points.length;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] p : points) {
			if (!map.containsKey(p[0])) map.put(p[0], new HashSet<>());
			map.get(p[0]).add(p[1]);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				int dx1 = points[j][0] - points[i][0];
				int dy1 = points[j][1] - points[i][1];
				double w = Math.sqrt(dx1 * dx1 + dy1 * dy1);
				for (int k = 0; k < n; k++) {
					if (i == k || j == k) continue;
					int dx2 = points[k][0] - points[j][0];
					int dy2 = points[k][1] - points[j][1];
					if (dx1 * dx2 + dy1 * dy2 != 0) continue;
					double d = Math.sqrt(dx2 * dx2 + dy2 * dy2);
					int key = points[k][0] - dx1;
					int val = points[k][1] - dy1;
					if (map.containsKey(key) && map.get(key).contains(val)) {
						min = Math.min(min, w * d);
					}
				}
			}
		}
		return min == Double.MAX_VALUE ? 0 : min;
	}
}
