import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0 || triangle.get(0).size() == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < triangle.size() - 1; i++) {
			count += triangle.get(i).size();
		}
		Map<String, Integer> mem = new HashMap<>(count);
		return dfs(triangle, 0, 0, mem);
	}
	private int dfs(List<List<Integer>> triangle, int i, int j, Map<String, Integer> mem) {
		if (i == triangle.size() - 1) {
			return triangle.get(i).get(j);
		}

		Integer cout = mem.get("" + i + "#" + j);
		if (cout != null) {
			return cout;
		}
		int min = Integer.MAX_VALUE;
		min = Math.min(min, dfs(triangle, i + 1, j, mem) + triangle.get(i).get(j));

		min = Math.min(min, dfs(triangle, i + 1, j + 1, mem) + triangle.get(i).get(j));

		mem.put("" + i + "#" + j, min);
		return min;
	}
}
