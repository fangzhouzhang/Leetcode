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
		// write your code here
		if (points == null || points.length == 0) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		Map<Params, Set<Point>> map = new HashMap<>();
		double a = 0;
		double b = 0;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Params params = null;
				if (points[j].x == points[i].x) {//parpendicular  MAX, b
					params = new Params(points[i].x);

				} else {
					a = (points[j].y - points[i].y) * 1.0 / (points[j].x - points[i].x);
					b = points[j].y * 1.0 - a * points[j].x;
					params = new Params(a, b);

				}
				if (map.containsKey(params)) {

				} else {
					map.put(params, new HashSet<Point>());
				}
				Set<Point> set = map.get(params);
				set.add(points[i]);
				set.add(points[j]);
			}
		}
		int max = 0;
		int size = 0;
		for (Params p : map.keySet()) {
			if (map.get(p).size() > max) {
				max = map.get(p).size();
			}
		}
		return max;
	}
	class Params {
		Double slope;
		Double intercept;
		Integer x;
		public Params(Integer x) {
			this.slope = null;
			this.intercept = null;
			this.x = x;
		}
		public Params(Double a, Double b) {
			this.slope = a;
			this.intercept = b;
			this.x = null;
		}
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Params p = (Params) o;

			if (slope != null ? !slope.equals(p.slope) : p.slope != null) return false;
			if (intercept != null ? !intercept.equals(p.intercept) : p.intercept != null) return false;
			if (x != null ? !x.equals(p.x) : p.x != null ) return false;
			return true;
		}

		@Override
		public int hashCode() {
			int result = slope != null ? slope.hashCode() : 0;
			result = 31 * result + (intercept != null ? intercept.hashCode() : 0);
			return result;
		}
	}
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
}

