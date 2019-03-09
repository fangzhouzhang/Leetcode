public class TicTacToe {
	private int[] rows;
	private int[] cols;
	private int size;
	private int diag;
	private int antidiag;
	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
		size = n;
		diag = 0;
		antidiag = 0;
	}

	/** Player {player} makes a move at ({row}, {col}).
	 @param row The row of the board.
	 @param col The column of the board.
	 @param player The player, can be either 1 or 2.
	 @return The current winning condition, can be either:
	 0: No one wins.
	 1: Player 1 wins.
	 2: Player 2 wins. */
	public int move(int row, int col, int player) {
		if (player == 1) {
			rows[row]++; cols[col]++;
			if (row == col) {
				diag++;
			}
			if (row + col == size - 1) {
				antidiag++;
			}
			if (rows[row] == size || cols[col] == size || diag == size || antidiag == size) {
				return 1;
			}
		} else if (player == 2) {
			rows[row]--; cols[col]--;
			if (row == col) {
				diag--;
			}
			if (row + col == size - 1) {
				antidiag--;
			}
			if (rows[row] == -1 * size || cols[col] == -1 * size || diag == -1 * size || antidiag == -1 * size) {
				return 2;
			}
		}
		return 0;
	}
}
