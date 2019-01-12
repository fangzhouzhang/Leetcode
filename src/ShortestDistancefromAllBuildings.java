import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancefromAllBuildings {
	private final int LAND = 0;
	private final int BUILDING = 1;
	private final int OBSTACLE = 2;
	private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return -1;
		}
		int[] buildNum = new int[1];
		if (!isValidGrid(grid, buildNum)) {
			return -1;
		}
		Queue<Coord> q = new LinkedList<>();
		int[][] res = new int[grid.length][grid[0].length];
		boolean[][] qualified = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == LAND) {
					int num = bfs(q, grid, i, j, new boolean[grid.length][grid[0].length], res);
					if (num == buildNum[0]) {
						qualified[i][j] = true;
					}
				}
			}
		}

		// for (int i = 0; i < grid.length; i++) {
		//     for (int j = 0; j < grid[0].length; j++) {
		//         System.out.print(res[i][j] + " ");
		//     }
		//     System.out.println();
		// }

		int min = getMin(res, grid, qualified);
		return min;
	}
	private boolean isValidGrid(int[][] grid, int[] buildNum) {
		boolean hasBuilding = false;
		boolean hasLand = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == LAND) {
					hasLand = true;
				} else if (grid[i][j] == BUILDING) {
					hasBuilding = true;
					buildNum[0]++;
				}
			}
		}
		if (hasBuilding == false || hasLand == false) {
			return false;
		}
		return true;
	}
	private int getMin(int[][] res, int[][] grid, boolean[][] qualified) {
		int temp = Integer.MAX_VALUE;
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				if (qualified[i][j] == false) {
					continue;
				}
				if (grid[i][j] == LAND && res[i][j] < temp && res[i][j] > 0) {
					temp = res[i][j];
				}
			}
		}
		return temp == Integer.MAX_VALUE ? -1 : temp;
	}
	private boolean isValid(int[][] grid,
							int i,
							int j,
							boolean[][] visit) {
		if (i < 0 || i >= grid.length) {
			return false;
		}
		if (j < 0 || j >= grid[0].length) {
			return false;
		}
		if (grid[i][j] == OBSTACLE) {
			return false;
		}
		if (visit[i][j] == true) {
			return false;
		}
		return true;
	}
	private int bfs(Queue<Coord> q,
					int[][] grid,
					int i,
					int j,
					boolean[][] visit,
					int[][] res) {
		int add = 0;
		q.add(new Coord(i, j));
		visit[i][j] = true;
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				Coord coord = q.poll();
				int row = coord.row;
				int col = coord.col;
				if (grid[row][col] == BUILDING) {
					res[i][j] += step;
					add++;
					continue;
				}
				for (int[] dir: dirs) {
					if (isValid(grid, row + dir[0], col + dir[1], visit)) {
						q.add(new Coord(row + dir[0], col + dir[1]));
						visit[row + dir[0]][col + dir[1]] = true;
					}
				}

			}
			step++;
		}
		return add;
	}
	private class Coord {
		private int row;
		private int col;
		public Coord(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
