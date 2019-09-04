import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return nums1 == null ? nums2 : nums1;
		}
		if (nums1.length > nums2.length) {
			return intersection(nums2, nums1);
		}
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int num : nums1) {
			set1.add(num);
		}
		for (int num : nums2) {
			set2.add(num);
		}
		set1.retainAll(set2);
		int[] res = new int[set1.size()];
		int idx = 0;
		for (int num : set1) {
			res[idx++] = num;
		}
		return res;
	}
}
