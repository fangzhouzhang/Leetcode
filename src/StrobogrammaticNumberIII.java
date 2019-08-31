import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberIII {
	public int strobogrammaticInRange(String low, String high) {
		int count = 0;
		List<String> list = new ArrayList<>();
		for (int i = low.length(); i <= high.length(); i++) {
			list.addAll(helper(i, i));
		}
		for (String num : list) {
			if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)) {
				continue;
			}
			count++;
		}
		return count;
	}

	private List<String> helper(int n, int m) {
		List<String> list = new ArrayList<>();
		if (n < 1) {
			list.add("");
			return list;
		}
		if (n == 1) {
			list.add("0");
			list.add("1");
			list.add("8");
			return list;
		}
		List<String> prev = helper(n - 2, m);
		for (String p : prev) {
			if (n != m) {
				list.add("0" + p + "0");
			}
			list.add("1" + p + "1");
			list.add("8" + p + "8");
			list.add("6" + p + "9");
			list.add("9" + p + "6");
		}
		return list;
	}
}
