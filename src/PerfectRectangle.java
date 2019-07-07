import java.util.*;

public class PerfectRectangle {
	public boolean isRectangleCover(int[][] rectangles) {
		Set<Pair> set = new HashSet<>();
		int area = 0;
		for (int[] rec: rectangles) {
			Pair p0 = new Pair(rec[0], rec[1]);
			Pair p1 = new Pair(rec[0], rec[3]);
			Pair p2 = new Pair(rec[2], rec[1]);
			Pair p3 = new Pair(rec[2], rec[3]);
			if (!set.add(p0)) {
				set.remove(p0);
			}
			if (!set.add(p1)) {
				set.remove(p1);
			}
			if (!set.add(p2)) {
				set.remove(p2);
			}
			if (!set.add(p3)) {
				set.remove(p3);
			}
			area += (p3.x- p0.x) * (p3.y - p0.y);
		}
		if (set.size() != 4) {
			//System.out.println(set.size());
			return false;
		}
		List<Pair> list = new ArrayList<>();
		for (Pair p : set) {
			list.add(p);
		}
		Collections.sort(list, new MyComparator());
		int newArea = (list.get(3).x - list.get(0).x) * (list.get(3).y - list.get(0).y);
		return area == newArea;
	}
	private class Pair {
		private int x;
		private int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair p = (Pair)o;
				return this.x == p.x && this.y == p.y;
			}
			return false;
		}

		public int hashCode() {
			int code = 1;
			code = code * 31 + x;
			code = code * 31 + y;
			return code;
		}
	}
	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair p0, Pair p1) {
			if (p0.x != p1.x) {
				return p0.x - p1.x;
			} else {
				return p0.y - p1.y;
			}
		}
	}
}
