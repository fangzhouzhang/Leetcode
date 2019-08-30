import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
		return getList(n, n);
	}
	private List<String> getList(int n, int m) {
		List<String> res = new ArrayList<>();
		if (n < 1) {
			res.add("");
			return res;
		}
		if (n == 1) {
			res.add("0");
			res.add("1");
			res.add("8");
			return res;
		}
		List<String> numbers = getList(n - 2, n);
		for (String num: numbers) {
			if (n != m) {
				res.add("0" + num + "0");
			}
			res.add("1" + num + "1");
			res.add("8" + num + "8");
			res.add("6" + num + "9");
			res.add("9" + num + "6");
		}
		return res;
	}
}
