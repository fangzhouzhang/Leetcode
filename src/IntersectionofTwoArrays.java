import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> intersect = new HashSet<>();
		for (int n : nums1) set.add(n);
		for (int n : nums2) {
			if (set.contains(n)) {
				intersect.add(n);
			}
		}

		int[] res = new int[intersect.size()];
		int idx = 0;
		for (int n : intersect) res[idx++] = n;
		return res;
	}
}
