import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
	public int[][] kClosest(int[][] points, int k) {
		if (points == null || points.length == 0) {
			return new int[0][0];
		}
		PriorityQueue<Coord> pq = new PriorityQueue<>(k, new MyComparator());
		for (int i = 0; i < points.length; i++) {
			if (pq.isEmpty() || pq.size() < k) {
				pq.add(new Coord(points[i][0], points[i][1]));
				// System.out.println(points[i][0] + "  " + points[i][1]);
			} else if (pq.size() == k) {
				Coord c1 = pq.peek();
				// System.out.println(((c1.x - 0) * (c1.x - 0) + (c1.y - 0) * (c1.y - 0)) + " >> " + ((points[i][0] - 0) * (points[i][0] - 0) + (points[i][1] - 0) * (points[i][1] - 0)));
				if ((c1.x - 0) * (c1.x - 0) + (c1.y - 0) * (c1.y - 0) >
						(points[i][0] - 0) * (points[i][0] - 0) + (points[i][1] - 0) * (points[i][1] - 0)) {
					pq.poll();
					pq.add(new Coord(points[i][0], points[i][1]));
				}
			}
		}
		int[][] res = new int[k][2];
		for (int i = k - 1; i >= 0; i--) {
			Coord coord = pq.poll();
			res[i][0] = coord.x;
			res[i][1] = coord.y;
		}
		return res;
	}
	private class MyComparator implements Comparator<Coord> {
		public int compare(Coord c1, Coord c2) {
			int dis1 = (c1.x - 0) * (c1.x - 0) + (c1.y - 0) * (c1.y - 0);
			int dis2 = (c2.x - 0) * (c2.x - 0) + (c2.y - 0) * (c2.y - 0);
			return dis2 - dis1;
		}
	}
	private class Coord {
		private int x;
		private int y;
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
