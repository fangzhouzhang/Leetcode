import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrogJump {
	public boolean canCross(int[] stones) {
		//HashMap<Integer, Boolean>[] maps = new HashMap<Integer, Boolean>[stones.length];
		List<HashMap<Integer, Boolean>> maps = new ArrayList<>();
		for (int i = 0; i < stones.length; i++) {
			maps.add(new HashMap<Integer, Boolean>());
		}
		return dfs(stones, maps, 0, 0);
	}
	private boolean dfs(int[] stones, List<HashMap<Integer, Boolean>> maps, int idx, int k) {
		if (idx == stones.length - 1) {
			return true;
		}
		Boolean val = maps.get(idx).get(k);
		if (val != null) {
			return val;
		}
		for (int i = idx + 1; i < stones.length; i++) {
			int dis = stones[i] - stones[idx];
			if (dis < k - 1) {
				continue;
			} else if (dis > k + 1) {
				break;
			} else {
				//within k - 1 to k + 1
				if (dfs(stones, maps, i, dis)) {
					maps.get(idx).put(k, true);
					return true;
				}
			}
		}
		maps.get(idx).put(k, false);
		return false;
	}
}
