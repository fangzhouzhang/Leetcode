import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		int cur = 1;
		for (int i = 0; i < n; i++) {
			res.add(cur);
			if (cur * 10 <= n) {
				cur *= 10;
			} else {
				if (cur >= n) {
					cur /= 10;
				}
				cur += 1;
				while (cur % 10 == 0) {
					cur /= 10;
				}
			}
		}
		return res;
	}
}
