import java.util.ArrayList;
import java.util.List;

public class N_Queens {
	/*
	 * @param n: The number of queens
	 * @return: All distinct solutions
	 * time : o(n!) space: o(n)
	 */
	public List<List<String>> solveNQueens(int n) {
		// write your code here
		List<List<String>> res = new ArrayList<List<String>>();
		if (n <= 0) {
			return res;
		}
		//array to store the pos number of queen at each row
		int[] queenPos = new int[n];
		helper(res, queenPos, 0);
		return res;
	}
	public void helper(List<List<String>> res,
					   int[] queenPos,
					   int pos) {
		if (pos == queenPos.length) {
			addResult(res, queenPos, new ArrayList<String>());
			return;
		}
		for (int i = 0; i < queenPos.length; i++) {
			queenPos[pos] = i;
			if (isValid(queenPos, pos)) {
				helper(res, queenPos, pos + 1);
			}
		}
	}
	public boolean isValid(int[] queenPos, int pos) {
		for (int i = 0; i < pos; i++) {
			if (queenPos[i] == queenPos[pos]) {
				return false;
			} else if (Math.abs(queenPos[i] - queenPos[pos]) == Math.abs(pos - i)) {
				return false;
			}
		}
		return true;
	}
	public void addResult(List<List<String>> res,
						  int[] queenPos,
						  List<String> list) {
		for (int i = 0; i < queenPos.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < queenPos.length; j++) {
				if (queenPos[i] == j) {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			list.add(sb.toString());
		}
		res.add(list);
	}
}
