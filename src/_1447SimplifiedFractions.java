import java.util.ArrayList;
import java.util.List;

public class _1447SimplifiedFractions {
	public List<String> simplifiedFractions(int n) {
		List<String> res = new ArrayList<>();
		if (n == 1) return res;
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (getGcd(i, j) == 1) {
					String cur = i + "/" + j;
					res.add(cur);
				}
			}
		}
		return res;
	}

	private int getGcd(int a, int b) {
		if (b == 0) return a;
		return getGcd(b, (a % b));
	}
}
