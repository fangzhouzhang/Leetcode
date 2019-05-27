public class SurroundedRegions {
	public int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}

		boolean[][] b = new boolean[board.length][board[0].length];
		boolean[][] visit = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				search(board, b, i, 0, visit);
			}
			if (board[i][board[0].length - 1] == 'O') {
				search(board, b, i, board[0].length - 1, visit);
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				search(board, b, 0, i, visit);
			}
			if (board[board.length - 1][i] == 'O') {
				search(board, b, board.length - 1, i, visit);
			}
		}
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if (board[i][j] == 'O' && b[i][j] != true) {
					board[i][j] = 'X';
				}
			}
		}
	}
	private void search(char[][] board, boolean[][] b, int i, int j, boolean[][] visit) {
		for (int[] dir : dirs) {
			int newRow = i + dir[0];
			int newCol = j + dir[1];
			if (isValid(board, newRow, newCol) && board[newRow][newCol] == 'O' && !visit[newRow][newCol]) {
				b[newRow][newCol] = true;
				visit[newRow][newCol] = true;
				search(board, b, newRow, newCol, visit);
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
		return true;
	}
}
