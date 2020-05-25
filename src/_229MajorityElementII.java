import java.util.ArrayList;
import java.util.List;

public class _229MajorityElementII {
    /**
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     * time: o(n) space: o(1)
     */
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		Integer c1 = null, c2 = null;
		int f1 = 0, f2 = 0;
		for (int n : nums) {
			if (c1 != null && c1 == n) f1++;
			else if (c2 != null && c2 == n) f2++;
			else if (c1 == null || f1 == 0) {
				c1 = n;
				f1 = 1;
			} else if (c2 == null || f2 == 0) {
				c2 = n;
				f2 = 1;
			} else if (c1 != null && c2 != null && c1 != n && c2 != n) {
				f1--;
				f2--;
			}
		}

		f1 = 0; f2 = 0;
		for (int n : nums) {
			if (c1 != null && c1 == n) f1++;
			if (c2 != null && c2 == n) f2++;
		}
		if (f1 > nums.length / 3) res.add(c1);
		if (f2 > nums.length / 3) res.add(c2);
		return res;
	}
}

