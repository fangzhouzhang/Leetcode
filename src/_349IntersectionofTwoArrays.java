import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _349IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) return new int[0];
		if (nums1.length < nums2.length) {
			return intersection(nums2, nums1);
		}
		Set<Integer> set = new HashSet<>();
		for (int n : nums2) {
			set.add(n);
		}
		List<Integer> list = new ArrayList<>();
		for (int n : nums1) {
			if (set.contains(n)) {
				list.add(n);
				set.remove(n);
			}

		}
		int[] res = new int[list.size()];
		int idx = 0;
		for (int n : list) {
			res[idx++] = n;
		}
		return res;
	}
}
