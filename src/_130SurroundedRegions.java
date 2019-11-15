import java.util.HashMap;
import java.util.Map;

public class _130SurroundedRegions {
	private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}
		int n = board.length - 1;
		int m = board[0].length - 1;
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') search(board, i, 0);
			if (board[i][m] == 'O') search(board, i, m);
		}

		for (int i = 0; i <= m; i++) {
			if (board[0][i] == 'O') search(board, 0, i);
			if (board[n][i] == 'O') search(board, n, i);
		}

		Map<Character, Character> map = new HashMap<>();
		map.put('R', 'O');
		map.put('O', 'X');
		map.put('X', 'X');

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				board[i][j] = map.get(board[i][j]);
			}
		}
	}
	private void search(char[][] board, int i, int j) {
		board[i][j] = 'R';
		for (int[] dir : dirs) {
			int newRow = i + dir[0];
			int newCol = j + dir[1];
			if (isValid(board, newRow, newCol) && board[newRow][newCol] == 'O') {
				search(board, newRow, newCol);
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
