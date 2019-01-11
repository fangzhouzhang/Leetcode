import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {
	class Solution {
		private final int WALL = -1;
		private final int GATE = 0;
		private final int EMPTY_ROOM = Integer.MAX_VALUE;
		private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		public void wallsAndGates(int[][] rooms) {
			if (rooms == null || rooms.length == 0) {
				return;
			}
			// boolean[][] visit = new boolean[rooms.length][rooms[0].length];
			boolean[][] isEmptyRoom = new boolean[rooms.length][rooms[0].length];
			for (int i = 0; i < rooms.length; i++) {
				for (int j = 0; j < rooms[0].length; j++) {
					if (rooms[i][j] == EMPTY_ROOM) {
						isEmptyRoom[i][j] = true;
					}
				}
			}

			Queue<Coord> q = new LinkedList<>();
			for (int i = 0; i < rooms.length; i++) {
				for (int j = 0; j < rooms[0].length; j++) {
					if (rooms[i][j] == GATE) {
						bfs(q, rooms, i, j, new boolean[rooms.length][rooms[0].length], isEmptyRoom);
					}
				}
			}
		}
		private void bfs(Queue<Coord> q,
						 int[][] rooms,
						 int i,
						 int j,
						 boolean[][] visit,
						 boolean[][] isEmptyRoom) {
			q.add(new Coord(i, j));
			int step = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int k = 0; k < size; k++) {
					Coord coord = q.poll();
					int row = coord.row;
					int col = coord.col;
					for (int[] dir: dirs) {
						if (isValid(rooms, row + dir[0], col + dir[1], visit)) {
							q.add(new Coord(row + dir[0], col + dir[1]));
							visit[row + dir[0]][col + dir[1]] = true;
						}
					}
					if (isEmptyRoom[row][col] == true) {
						rooms[row][col] = Math.min(rooms[row][col], step);
					}
				}
				step++;
			}
		}
		private class Coord {
			private int row;
			private int col;
			public Coord(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}
		private boolean isValid(int[][] rooms, int i, int j, boolean[][] visit) {
			if (i < 0 || i >= rooms.length) {
				return false;
			}
			if (j < 0 || j >= rooms[0].length) {
				return false;
			}
			if (rooms[i][j] == WALL || rooms[i][j] == GATE) {
				return false;
			}
			if (visit[i][j] == true) {
				return false;
			}
			return true;
		}
	}
}
