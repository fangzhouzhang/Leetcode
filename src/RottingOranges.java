import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
	private final int EMPTY = 0;
	private final int FRESH = 1;
	private final int ROTTEN = 2;
	private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public int orangesRotting(int[][] grid) {
		List<Integer> rotPos = new ArrayList<>();
		int oranges = getOrange(grid, rotPos);

		if (oranges == 0) {
			return 0;
		}
		if (rotPos.size() == 0) {
			return -1;
		}
		int global = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visit = new boolean[grid.length][grid[0].length];
		fillQueue(q, rotPos, visit);

		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int val = q.poll();
				int row = val / grid[0].length;
				int col = val % grid[0].length;
				if (grid[row][col] == FRESH) {
					grid[row][col] = ROTTEN;
					oranges--;
				}
				for (int[] dir: dirs) {
					if (isValid(grid, visit, row + dir[0], col + dir[1])) {
						q.add((row + dir[0]) * grid[0].length + (col + dir[1]));
						visit[row + dir[0]][col + dir[1]] = true;
					}
				}
			}
			count++;
		}
		return oranges == 0 ? count - 1 : -1;
	}
	private int getOrange(int[][] grid, List<Integer> rotPos) {
		int oranges = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == FRESH) {
					oranges++;
				} else if (grid[i][j] == ROTTEN) {
					rotPos.add(i * grid[0].length + j);
				}
			}
		}
		return oranges;
	}

	private boolean isValid(int[][] grid, boolean[][] visit, int row, int col) {
		if (row < 0 || row >= grid.length) {
			return false;
		}
		if (col < 0 || col >= grid[0].length) {
			return false;
		}
		if (visit[row][col] == true) {
			return false;
		}
		if (grid[row][col] == EMPTY || grid[row][col] == ROTTEN) {
			return false;
		}
		return true;
	}
	private void fillQueue(Queue<Integer> q, List<Integer> rotPos, boolean[][] visit) {
		for (Integer val : rotPos) {
			q.add(val);
			int row = val / visit[0].length;
			int col = val % visit[0].length;
			visit[row][col] = true;
		}
	}
}
