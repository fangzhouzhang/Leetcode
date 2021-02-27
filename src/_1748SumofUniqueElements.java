import java.util.ArrayList;
import java.util.List;

public class _1748SumofUniqueElements {
	public int sumOfUnique(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		List<Integer>[] arr = new List[101];
		for (int i = 1; i <= 100; i++) arr[i] = new ArrayList<>();
		for (int x : nums) {
			arr[x].add(1);
		}
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (arr[i].size() == 1) sum += i;
		}
		return sum;
	}
}
