import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMazeIII {
	private int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
	private char[] dirChars = {'d', 'l', 'r', 'u'};
	boolean[][] marked;
	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		if (maze.length == 0 || maze[0].length == 0) {
			return "impossible";
		}
		marked = new boolean[maze.length][maze[0].length];
		PriorityQueue<Point> pq = new PriorityQueue<>(new MyComparator());
		pq.add(new Point(ball[0], ball[1], 0, ""));
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			int r = p.row;
			int c = p.col;
			int dist = p.dist;
			String path = p.path;
			if (r == hole[0] && c == hole[1]) return path;
			marked[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int newR = r;
				int newC = c;
				int newD = dist;
				while (inbound(maze, newR, newC) && maze[newR][newC] == 0 && (newR != hole[0] || newC != hole[1])) {
					newR += dirs[i][0];
					newC += dirs[i][1];
					newD += 1;
				}
				if (newR != hole[0] || newC != hole[1]) {
					newR -= dirs[i][0];
					newC -= dirs[i][1];
					newD -= 1;
				}

				if (!marked[newR][newC]) {
					pq.add(new Point(newR, newC, newD, path + dirChars[i]));
				}
			}
		}
		return "impossible";
	}

	private boolean inbound(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length) {
			return false;
		}
		if (col < 0 || col >= grid[0].length) {
			return false;
		}
		return true;
	}

	private class MyComparator implements Comparator<Point> {
		public int compare(Point a, Point b) {
			if (a.dist == b.dist) {
				return a.path.compareTo(b.path);
			} else {
				return a.dist - b.dist;
			}
		}
	}

	private class Point {
		int row;
		int col;
		int dist;
		String path;
		public Point(int row, int col, int dist, String path) {
			this.row = row;
			this.col = col;
			this.dist = dist;
			this.path = path;
		}
	}
}
