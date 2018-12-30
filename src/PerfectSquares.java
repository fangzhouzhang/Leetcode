import java.util.*;

public class PerfectSquares {
	/**
	 * branches: log 4 (input)
	 * levels: number of perfect squares before input
	 * @param n
	 * @return
	 */
	public int numSquaresDFS(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}


		List<Integer> squares = getSquares(n);
		Set<Integer> set = new HashSet<>(squares);

		if (set.contains(n)) {
			return 1;
		}

		int[] res = new int[1];
		res[0] = n;
		List<Integer> temp = new ArrayList<>();
		dfs(squares, temp, res, n, 0, 0);
		return res[0];
	}
	private List<Integer> getSquares(int n) {
		List<Integer> squares = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) {
			squares.add(i * i);
		}
		return squares;
	}
	private void dfs(List<Integer> squares,
					 List<Integer> temp,
					 int[] res,
					 int n,
					 int sum,
					 int level) {
		if (sum == n) {
			res[0] = Math.min(res[0], temp.size());
			return;
		}

		if (level >= squares.size()) {
			return;
		}

		int square = squares.get(level);

		for (int i = 0; sum + i * square <= n; i++) {
			add(temp, square, i);
			dfs(squares, temp, res, n, sum + i * square, level + 1);
			remove(temp, i);
		}
	}
	private void add(List<Integer> temp, int square, int num) {
		for (int i = 0; i < num; i++) {
			temp.add(square);
		}
	}
	private void remove(List<Integer> temp, int num) {
		for (int i = 0; i < num; i++) {
			temp.remove(temp.size() - 1);
		}
	}

	/**
	 * time: o(n^2)
	 * @param n
	 * @return
	 */
	public int numSquaresDP(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}


		List<Integer> squares = getSquares(n);

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = squares.size() - 1; i >= 0 ; i--) {
			dp[squares.get(i)] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; i + j * j <= n; j++) {
				dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
			}
		}
		return dp[n];
	}
}
