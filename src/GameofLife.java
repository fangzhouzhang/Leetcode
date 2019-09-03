public class GameofLife {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	private final int LIVE = 1;
	private final int DEAD = 0;
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int lives = 0;
				if ((board[i][j] & 1) == LIVE) {
					lives++;
				}
				for (int[] dir : dirs) {
					if (inbound(board, i + dir[0], j + dir[1]) && (board[i + dir[0]][j + dir[1]] & 1) == LIVE) {
						lives++;
					}
				}
				if (lives == 3 || (lives == 4 && board[i][j] == LIVE)) {
					board[i][j] |= 0b10;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] >>= 1;
			}
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
