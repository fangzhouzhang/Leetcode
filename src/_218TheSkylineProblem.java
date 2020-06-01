import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _218TheSkylineProblem {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> res = new ArrayList<>();
		if (buildings == null || buildings.length == 0) return res;
		List<Point> points = new ArrayList<>();
		for (int[] b : buildings) {
			points.add(new Point(b[0], b[2], false));
			points.add(new Point(b[1], b[2], true));
		}
		Collections.sort(points, new MyComparator());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new DesComparator());
		for (Point p : points) {
			if (p.isEnd) {
				pq.remove(p.y);
				if (pq.size() == 0 || p.y > pq.peek()) {
					int h = pq.size() == 0 ? 0 : pq.peek();
					List<Integer> list = new ArrayList<>();
					list.add(p.x);
					list.add(h);
					res.add(list);
				}
			} else {
				if (pq.size() == 0 || p.y > pq.peek()) {
					List<Integer> list = new ArrayList<>();
					list.add(p.x);
					list.add(p.y);
					res.add(list);
				}
				pq.add(p.y);
			}
		}
		return res;
	}

	private class MyComparator implements Comparator<Point> {
		public int compare(Point a, Point b) {
			if (a.x != b.x) return a.x - b.x;
			else {
				if (a.isEnd && b.isEnd) {
					return a.y - b.y;
				} else if (!a.isEnd && !b.isEnd) {
					return b.y - a.y;
				} else {
					return a.isEnd ? 1 : -1;
				}
			}
		}
	}

	private class DesComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}

	private class Point {
		int x;
		int y;
		boolean isEnd;
		Point(int x, int y, boolean isEnd) {
			this.x = x;
			this.y = y;
			this.isEnd = isEnd;
		}
	}
}
