import java.util.*;

public class TheSkylineProblem {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> res = new ArrayList<>();
		if (buildings.length == 0 || buildings[0].length == 0) {
			return res;
		}
		List<Point> points = new ArrayList<>();
		for (int[] b: buildings) {
			points.add(new Point(b[0], b[2], true));
			points.add(new Point(b[1], b[2], false));
		}
		Collections.sort(points, new MyComparator());
		// TreeSet<Integer> set = new TreeSet<>(new SetComparator());
		PriorityQueue<Integer> set = new PriorityQueue<>(new SetComparator());

		for (Point p: points) {
			if (p.isLeft) {
				if (set.isEmpty() || p.height > set.peek()) {
					List<Integer> temp = new ArrayList<>();
					temp.add(p.val);
					temp.add(p.height);
					res.add(temp);
				}
				set.add(p.height);
			} else {
				set.remove(p.height);
				if (set.isEmpty() || p.height > set.peek()) {
					List<Integer> temp = new ArrayList<>();
					temp.add(p.val);
					temp.add(set.isEmpty() ? 0 : set.peek());
					res.add(temp);
				}
			}
		}
		return res;
	}
	private class Point {
		private int val;
		private int height;
		private boolean isLeft;
		public Point(int val, int height, boolean isLeft) {
			this.val = val;
			this.height = height;
			this.isLeft = isLeft;
		}
	}
	private class SetComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}
	private class MyComparator implements Comparator<Point> {

		public int compare(Point a, Point b) {
			if (a.val != b.val) {
				return a.val - b.val;
			} else {
				if (a.isLeft && b.isLeft) {
					return b.height - a.height;
				} else if (!a.isLeft && !b.isLeft) {
					return a.height - b.height;
				} else {
					return a.isLeft ? -1 : 1;
				}
			}

		}
	}
}
