import java.util.HashMap;
import java.util.Map;

public class _1056ConfusingNumber {
	//https://blog.csdn.net/fuxuemingzhu/article/details/100992424
	public boolean confusingNumber(int N) {
		try {
			if (N < 0) throw new Exception();
		} catch (Exception e) {
			System.out.println("Input is not valid");
		}
		int rotate = 0, cur = N;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(6, 9);
		map.put(9, 6);
		map.put(8, 8);
		map.put(0, 0);
		while (cur > 0) {
			int mod = cur % 10;
			if (!map.containsKey(mod)) return false;
			rotate = 10 * rotate + map.get(mod);
			cur /= 10;
		}
		return rotate != N;
	}
}
