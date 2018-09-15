import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonNumbersOfTwoArraysI {
	/**
	 * @param a array(size m)
	 * @param b array(size n)
	 * @return common numbers in two array
	 * time: m log n  space: o(1)
	 */
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		// Write your solution here
		if (a.size() > b.size()) {
			return common(b,a);
		}

		List<Integer> res = new ArrayList<>();
		if (a.size() == 0) {
			return res;
		}
		Collections.sort(a);
		Collections.sort(b);
		for (int i = 0; i < a.size(); i++) {
			if (search(a.get(i), b)) {
				res.add(a.get(i));
			}
		}
		return res;
	}
	public boolean search(Integer target, List<Integer> b) {
		int start = 0;
		int end = b.size() - 1;
		int mid = 0;
		while (start + 1 < end) {
			mid = (end - start) / 2 + start;
			if (b.get(mid) == target) {
				return true;
			} else if (b.get(mid) > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (b.get(start) == target) {
			return true;
		}
		if (b.get(end) == target) {
			return true;
		}
		return false;
	}
}
