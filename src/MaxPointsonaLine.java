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
	public int maxPoints(Point[] points) {
		if (points.length <= 1) {
			return points.length;
		}

		Map<Slope, Integer> map = new HashMap<>();
		int[] global = new int[1];
		for (int i = 0; i < points.length; i++) {
			calcMax(points, i, map, global);

		}

		return global[0];
	}
	private void calcMax(Point[] points, int i, Map<Slope, Integer> map, int[] global) {
		int local = 0;
		int same = 0;
		for (int j = 0; j < points.length; j++) {
			// if (i == j) {
			//     continue;
			// }
			if (points[i].x == points[j].x && points[i].y == points[j].y) {
				same++;
				continue;
			}
			int cur = 0;
			if (points[i].x == points[j].x) {
				cur = addMap(map, 0, points[i].x);
			} else if (points[i].y == points[j].y) {
				cur = addMap(map, points[i].y, 0);
			} else {
				cur = addMap(map, points[i].y - points[j].y, points[i].x - points[j].x);
			}
			// System.out.println(local + " " + cur);
			local = Math.max(local, cur);
		}
		map.clear();
		global[0] = Math.max(global[0], local + same);

	}
	private int addMap(Map<Slope, Integer> map, int dy, int dx) {
		Slope slope = new Slope(dy, dx);
		if (map.containsKey(slope)) {
			map.put(slope, map.get(slope) + 1);
		} else {
			map.put(slope, 1);
		}
		return map.get(slope);
	}
	private class Slope {
		private int dx;
		private int dy;
		public Slope(int dy, int dx) {
			if (dy == 0 || dx == 0) {
				this.dy = dy;
				this.dx = dx;
			} else {
				int num = gcd(dy, dx);
				// System.out.println(dy + "  " + dx + "  " + num);
				this.dy = dy / num;
				this.dx = dx / num;
			}

		}
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			Slope s = (Slope)obj;
			if (this.dy != s.dy || this.dx != s.dx) {
				return false;
			}
			return true;
		}
		public int hashCode() {
			return 1;
		}
	}

	private int gcd(int m, int n) {
		return n == 0 ? m : gcd(n, m % n);
	}
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
}

