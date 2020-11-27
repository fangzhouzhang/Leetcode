import java.util.HashMap;
import java.util.Map;

public class _914XofaKindinaDeckofCards {
	public boolean hasGroupsSizeX(int[] deck) {
		if (deck == null || deck.length <= 1) return false;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int a : deck) {
			map.put(a, map.getOrDefault(a, 0) + 1);
			max = Math.max(max, map.get(a));
		}
		for (Map.Entry<Integer, Integer> e: map.entrySet()) {
			max = getGcd(max, e.getValue());
		}
		return max > 1;
	}

	private int getGcd(int a, int b) {
		if (b == 0) return a;
		return getGcd(b, a % b);
	}
}
