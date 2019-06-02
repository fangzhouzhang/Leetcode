import java.util.*;

public class RandomPickIndex {
	private Random r;
	private int[] a;
	public RandomPickIndex(int[] nums) {
		r = new Random();
		a = nums;
	}

	public int pick(int target) {
		//pick any 1 from target list
		int res = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) {
				int index = r.nextInt(++count);
				if (index == 0) {
					res = i;
				}
			}
		}
		return res;
	}
}
