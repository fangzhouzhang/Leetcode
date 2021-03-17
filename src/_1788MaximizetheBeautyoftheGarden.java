import java.util.HashMap;
import java.util.Map;

public class _1788MaximizetheBeautyoftheGarden {
	public int maximumBeauty(int[] flowers) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for (int f : flowers) {
			if (map.containsKey(f)) {
				res = Math.max(res, sum - map.get(f) + f * 2);
			}
			if (f > 0) sum += f;
			if (!map.containsKey(f)) {
				map.put(f, sum);
			}
		}
		return res;
	}
}
