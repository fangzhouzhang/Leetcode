import java.util.HashMap;
import java.util.Map;

public class _1074NumberofSubmatricesThatSumtoTarget {
	private int R;
	private int C;
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) return 0;
		R = matrix.length;
		C = matrix[0].length;
		int res = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 1; i < R; i++) {
				matrix[i][j] += matrix[i - 1][j];
			}
		}
		for (int i = 0; i < R; i++) {
			res += subarraySum(matrix[i], target);
		}
		for (int i = 1; i < R; i++) {
			for (int k = 0; k < i; k++) {
				int[] cur = new int[C];
				for (int j = 0; j < C; j++) {
					cur[j] = matrix[i][j] - matrix[k][j];
				}
				res += subarraySum(cur, target);
			}
		}
		return res;
	}

	private int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		map.put(0, 1);
		for (int i = 0, sum = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				res += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
}
