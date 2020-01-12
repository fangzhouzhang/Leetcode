import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _835ImageOverlap {
	public int largestOverlap(int[][] A, int[][] B) {
		if (A == null || B == null) return 0;
		List<int[]> a = new ArrayList<>();
		List<int[]> b = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 1) a.add(new int[]{i, j});
				if (B[i][j] == 1) b.add(new int[]{i, j});
			}
		}
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		for (int[] as : a) {
			for (int[] bs : b) {
				String key = (as[0] - bs[0]) + "#" + (as[1] - bs[1]);
				if (!map.containsKey(key)) map.put(key, 1);
				else map.put(key, map.get(key) + 1);
				max = Math.max(max, map.get(key));
			}
		}
		return max;
	}
}
