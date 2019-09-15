import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums.length == 0) {
			return res;
		}
		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] < 0) {
				res.add(idx + 1);
			}
			nums[idx] = -nums[idx];
		}
		return res;
	}
}
