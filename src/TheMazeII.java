import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMazeII {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		if (maze.length == 0 || maze[0].length == 0) {
			return 0;
		}
		boolean[][] m = new boolean[maze.length][maze[0].length];
		PriorityQueue<Point> pq = new PriorityQueue<>(new MyComparator());
		pq.add(new Point(start[0], start[1], 0));
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			int r = p.row;
			int c = p.col;
			int dist = p.dist;
			if (r == destination[0] && c == destination[1]) return dist;
			m[r][c] = true;
			for (int[] dir : dirs) {
				int new_r = r;
				int new_c = c;
				int new_dist = dist;
				while (inbound(maze, new_r, new_c) && maze[new_r][new_c] == 0) {
					new_r += dir[0];
					new_c += dir[1];
					new_dist++;
				}
				new_r -= dir[0];
				new_c -= dir[1];
				new_dist--;
				if (!m[new_r][new_c]) {
					pq.add(new Point(new_r, new_c, new_dist));
				}
			}
		}
		return -1;
	}

	private class Point {
		int row;
		int col;
		int dist;
		public Point(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	private class MyComparator implements Comparator<Point> {
		public int compare(Point a, Point b) {
			return a.dist - b.dist;
		}
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
}
