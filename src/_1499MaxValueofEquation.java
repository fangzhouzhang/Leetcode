import java.util.ArrayDeque;
import java.util.Deque;

public class _1499MaxValueofEquation {
	public int findMaxValueOfEquation(int[][] points, int k) {
		Deque<Pair> dq = new ArrayDeque<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < points.length; i++) {
			int curX = points[i][0];
			int curDelta = points[i][1] - points[i][0];
			while (!dq.isEmpty() && curX - dq.peekFirst().x > k) {
				dq.pollFirst();
			}
			if (!dq.isEmpty()) max = Math.max(max, points[i][1] + points[i][0] + dq.peekFirst().delta);
			while (!dq.isEmpty() && (curDelta >= dq.peekLast().delta)) dq.pollLast();
			dq.addLast(new Pair(curX, curDelta));
		}
		return max;
	}

	private class Pair {
		int x;
		int delta;
		public Pair(int x, int delta) {
			this.x = x;
			this.delta = delta;
		}
	}
}
