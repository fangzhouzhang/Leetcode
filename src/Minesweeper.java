public class Minesweeper {
	private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	public char[][] updateBoard(char[][] board, int[] click) {
		int row = click[0];
		int col = click[1];
		if (board[row][col] == 'M') {
			board[row][col] = 'X';
			return board;
		}
		dfs(board, row, col);
		return board;
	}
	private void dfs(char[][] board, int row, int col) {
		int sum = 0;
		for (int[] dir : dirs) {
			if (isValid(board, row + dir[0], col + dir[1])) {
				if (board[row + dir[0]][col + dir[1]] == 'M') {
					sum += 1;
				}
			}
		}
		if (sum != 0) {
			board[row][col] = (char)(sum + '0');
			return;
		}
		// sum == 0
		board[row][col] = 'B';
		for (int[] dir : dirs) {
			if (isValid(board, row + dir[0], col + dir[1])) {
				dfs(board, row + dir[0], col + dir[1]);
			}
		}
	}
	private boolean isValid(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length) {
			return false;
		}
		if (j < 0 || j >= board[0].length) {
			return false;
		}
		if (board[i][j] == 'B') {
			return false;
		}
		if (board[i][j] >= '1' && board[i][j] <= '8') {
			return false;
		}
		return true;
	}
}
