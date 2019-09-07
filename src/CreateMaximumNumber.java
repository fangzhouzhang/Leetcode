import java.util.ArrayList;
import java.util.List;

public class CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		int[] ans = new int[k];
		for (int i = 0; i <= n1 && i <= k; i++) {
			if (i > nums1.length || k - i > nums2.length) {
				continue;
			}
			List<Integer> cat1 = pickUpElement(nums1, i);
			List<Integer> cat2 = pickUpElement(nums2, k - i);
			List<Integer> res = concatMaxNumber(cat1, cat2);
			ans = getMaxArray(ans, res);

		}
		return ans;
	}

	private int[] getMaxArray(int[] ans, List<Integer> res) {
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] < res.get(i)) {
				return copyList(ans, res);
			} else if (ans[i] > res.get(i)) {
				return ans;
			}
		}
		return ans;
	}

	private int[] copyList(int[] ans, List<Integer> res) {
		for (int i = 0; i < ans.length; i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}

	private List<Integer> pickUpElement(int[] nums, int k) {
		if (k == 0) {
			return new ArrayList<Integer>();
		}
		int to_pop = nums.length - k;
		List<Integer> sb = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			while (sb.size() > 0 && nums[i] > sb.get(sb.size() - 1) && to_pop > 0) {
				sb.remove(sb.size() - 1);
				to_pop--;
			}
			sb.add(nums[i]);
		}
		while (sb.size() > k) {
			sb.remove(sb.size() - 1);
		}
		return sb;
	}

	private List<Integer> concatMaxNumber(List<Integer> sb1, List<Integer> sb2) {
		List<Integer> res = new ArrayList<Integer>();
		int idx1 = 0;
		int idx2 = 0;
		while (idx1 < sb1.size() && idx2 < sb2.size()) {
			if (sb1.get(idx1) < sb2.get(idx2)) {
				res.add(sb2.get(idx2));
				idx2++;
			} else if (sb1.get(idx1) > sb2.get(idx2)){
				res.add(sb1.get(idx1));
				idx1++;
			} else {
				int tmp1 = idx1;
				int tmp2 = idx2;
				while (tmp1 < sb1.size() && tmp2 < sb2.size() && sb1.get(tmp1) == sb2.get(tmp2)) {
					tmp1++;
					tmp2++;
				}
				if ((tmp1 < sb1.size() && tmp2 < sb2.size()  && sb1.get(tmp1) < sb2.get(tmp2)) || (tmp1 >= sb1.size())) {
					res.add(sb2.get(idx2));
					idx2++;
				} else if ((tmp1 < sb1.size() && tmp2 < sb2.size()  && sb1.get(tmp1) > sb2.get(tmp2)) || (tmp2 >= sb2.size())) {
					res.add(sb1.get(idx1));
					idx1++;
				}
			}
		}
		if (sb1.size() == idx1) {
			for (int i = idx2; i < sb2.size(); i++) {
				res.add(sb2.get(i));
			}
		}
		if (sb2.size() == idx2) {
			for (int i = idx1; i < sb1.size(); i++) {
				res.add(sb1.get(i));
			}
		}
		return res;
	}
}
