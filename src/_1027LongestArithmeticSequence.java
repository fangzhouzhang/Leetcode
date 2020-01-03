import java.util.HashMap;
import java.util.Map;

public class _1027LongestArithmeticSequence {
	public int longestArithSeqLength(int[] A) {
		if (A == null || A.length == 0) return 0;
		Map<Integer, Integer>[] maps = new Map[A.length];
		int res = 2;
		for (int i = 1; i < A.length; i++) {
			maps[i] = new HashMap<Integer, Integer>();
			for (int j = 0; j < i; j++) {
				int diff = A[i] - A[j];
				if (maps[j] == null || !maps[j].containsKey(diff)) maps[i].put(diff, 2);
				else maps[i].put(diff, maps[j].get(diff) + 1);
				res = Math.max(res, maps[i].get(diff));
			}
		}
		return res;
	}
}
