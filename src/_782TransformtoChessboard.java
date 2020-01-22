public class _782TransformtoChessboard {
	public int movesToChessboard(int[][] board) {
		if (board == null || board.length == 0) return -1;
		int n = board.length, rowSum = 0, colSum = 0, rowToExchange = 0, colToExchange = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((board[0][0] ^ board[0][j] ^ board[i][0] ^ board[i][j]) != 0) return -1;
			}
		}
		for (int i = 0; i < n; i++) {
			rowSum += board[i][0];
			colSum += board[0][i];
			if (board[i][0] == (i % 2)) rowToExchange++;
			if (board[0][i] == (i % 2)) colToExchange++;
		}
		if (rowSum != n / 2 && rowSum != (n + 1) / 2) return -1;
		if (colSum != n / 2 && colSum != (n + 1) / 2) return -1;
		if (n % 2 == 1) {
			if (rowToExchange % 2 == 1) rowToExchange = n - rowToExchange;
			if (colToExchange % 2 == 1) colToExchange = n - colToExchange;
		} else {
			rowToExchange = Math.min(rowToExchange, n - rowToExchange);
			colToExchange = Math.min(colToExchange, n - colToExchange);
		}
		return (rowToExchange + colToExchange) / 2;
	}
}
