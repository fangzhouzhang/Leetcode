import java.util.HashMap;
import java.util.Map;

public class _1742MaximumNumberofBallsinaBox {
	public int countBalls(int lowLimit, int highLimit) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int k = lowLimit; k <= highLimit; k++) {
			int box = 0, i = k;
			while (i > 0) {
				box += i % 10;
				i /= 10;
			}
			map.put(box, map.getOrDefault(box, 0) + 1);
			max = Math.max(max, map.get(box));
		}
		return max;
	}
}
