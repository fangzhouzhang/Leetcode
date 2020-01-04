import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsonaLine {
	/**
	 * @param points: an array of point
	 * @return: An integer
	 * time: o(n^2) space: o(n)
	 */
	private final String VERTICAL = "VERTICAL";
	private final String HORIZONTAL = "HORIZONTAL";
	public int maxPoints(int[][] points) {
		if (points == null || points.length == 0) return 0;
		Set<String> set = new HashSet<>();
		int max = 1;
		for (int i = 0; i < points.length && !set.contains(points[i][0] + "#" + points[i][1]); i++) {
			int[] a = points[i];
			int localMax = 1;
			int same = 0;
			Map<String, Integer> map = new HashMap<>();
			for (int j = i + 1; j < points.length; j++) {
				int[] b = points[j];
				if (a[0] == b[0] && a[1] == b[1]) {
					same++;
					continue;
				}
				int y = a[1] - b[1];
				int x = a[0] - b[0];
				String slope = null;
				if (y == 0) {
					slope = VERTICAL;
				} else if (x == 0) {
					slope = HORIZONTAL;
				} else {
					int gcd = getGcd(y, x);
					if (gcd != 0) {
						y /= gcd;
						x /= gcd;
					}
					if ((x > 0 && y > 0) || (x > 0 && y > 0)) {
						slope = y + "#" + x;
					} else {
						slope = "-" + y + "#" + x;
					}
				}
				map.put(slope, map.getOrDefault(slope, 1) + 1);
				localMax = Math.max(localMax, map.get(slope));
			}
			max = Math.max(max, localMax + same);
			set.add((points[i][0] + "#" + points[i][1]));
		}
		return max;
	}

	private int getGcd(int y, int x) {
		if (x == 0) return y;
		return getGcd(x, (y % x));
	}
}

