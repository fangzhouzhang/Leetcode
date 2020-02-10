import java.util.HashSet;
import java.util.Set;

public class _939MinimumAreaRectangle {
	public int minAreaRect(int[][] points) {
		if (points == null || points.length == 0) return 0;
		Set<String> set = new HashSet<>();
		for (int[] p : points) {
			set.add(p[0] + "#" + p[1]);
		}
		int res = Integer.MAX_VALUE;
		for (int[] p : points) {
			for (int[] m : points) {
				if (p[0] != m[0] && p[1] != m[1]) {
					String k1 = p[0] + "#" + m[1];
					String k2 = m[0] + "#" + p[1];
					if (set.contains(k1) && set.contains(k2)) {
						res = Math.min(res, Math.abs(m[0] - p[0]) * Math.abs(m[1] - p[1]));
					}
				}
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
