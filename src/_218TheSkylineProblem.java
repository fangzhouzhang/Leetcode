import java.util.*;

public class _218TheSkylineProblem {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> res = new ArrayList<>();
		if (buildings == null || buildings.length == 0) return res;
		List<Point> points = new ArrayList<>();
		for (int[] b : buildings) {
			points.add(new Point(b[0], b[2], true));
			points.add(new Point(b[1], b[2], false));
		}
		Collections.sort(points, new MyComparator());
		PriorityQueue<Integer> set = new PriorityQueue<>(new SetComparator());
		for (Point p : points) {
			if (p.isLeft) {
				if (set.isEmpty() || set.peek() < p.height) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(p.val);
					tmp.add(p.height);
					res.add(tmp);
				}
				set.add(p.height);
			} else {
				set.remove(p.height);
				if (set.isEmpty() || set.peek() < p.height) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(p.val);
					int h = set.isEmpty() ? 0 : set.peek();
					tmp.add(h);
					res.add(tmp);
				}
			}
		}
		return res;
	}

	private class SetComparator implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}

	private class MyComparator implements Comparator<Point>{
		public int compare(Point a, Point b) {
			if (a.val != b.val) return a.val - b.val;
			else {
				if (a.isLeft && b.isLeft) return b.height - a.height;
				else if (!a.isLeft && !b.isLeft) return a.height - b.height;
				else return a.isLeft ? -1 : 1;
			}
		}
	}

	private class Point {
		int val;
		int height;
		boolean isLeft;
		public Point(int val, int height, boolean isLeft) {
			this.val = val;
			this.height = height;
			this.isLeft = isLeft;
		}
	}
}
