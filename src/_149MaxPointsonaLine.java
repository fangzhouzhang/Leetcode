import java.util.HashMap;
import java.util.Map;

public class _149MaxPointsonaLine {
	/**
	 * @param points: an array of point
	 * @return: An integer
	 * time: o(n^2) space: o(n)
	 */
	public int maxPoints(int[][] points) {
		if (null == points || 0 == points.length) return 0;
		if (1 == points.length) return 1;
		int max = 2;
		for (int i = 0; i < points.length; i++) {
			Map<String, Integer> map = new HashMap<>();
			int same = 0;
			int cmax = 1;
			for (int j = i + 1; j < points.length; j++) {
				int x = points[i][0] - points[j][0];
				int y = points[i][1] - points[j][1];
				String slope = null;
				if (x == 0 && y == 0) {
					same++;
					continue;
				}
				else if (x == 0 && y != 0) {
					slope = "v";
				} else if (x != 0 && y == 0) {
					slope = "0";
				} else {
					boolean neg = (x * y > 0) ? false : true;
					y = Math.abs(y);
					x = Math.abs(x);
					int gcd = getGcd(x, y);
					y = y / gcd;
					x = x / gcd;
					if (neg) {
						y = -1 * y;
					}
					slope = y + "#" + x;
				}
				if (map.containsKey(slope)) map.put(slope, map.get(slope) + 1);
				else map.put(slope, 2);
				cmax = Math.max(cmax, map.get(slope));
			}
			max = Math.max(max, cmax + same);
		}

		return max;
	}

	private int getGcd(int a, int b) {
		if (b == 0) return a;
		return getGcd(b, a % b);
	}
}

