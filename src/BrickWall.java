import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
		if (wall.size() == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (List<Integer> gap : wall) {
			int sum = 0;
			for (int i = 0; i < gap.size() - 1; i++) {
				sum += gap.get(i);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
				max = Math.max(max, map.get(sum));
			}
		}
		return wall.size() - max;
	}
}
