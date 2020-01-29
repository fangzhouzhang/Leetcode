import java.util.ArrayList;
import java.util.List;

public class _1313DecompressRunLengthEncodedList {
	public int[] decompressRLElist(int[] nums) {
		if (nums == null || nums.length == 0) return new int[0];
		List<Integer> list = new ArrayList<>();
		int idx = 0;
		while (idx < nums.length) {
			int fre = nums[idx];
			int val = nums[idx + 1];
			for (int k = 0; k < fre; k++) list.add(val);
			idx += 2;
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) res[i] = list.get(i);
		return res;
	}
}
