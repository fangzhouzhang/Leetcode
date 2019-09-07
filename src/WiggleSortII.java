import java.util.Arrays;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int prevIdx = (nums.length - 1) / 2;
		int postIdx = nums.length - 1;
		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = nums[i];
		}
		int flag = 0;
		for (int i = 0; i < res.length; i++) {
			if (flag == 0) {
				nums[i] = res[prevIdx--];
			} else {
				nums[i] = res[postIdx--];
			}
			flag = 1 - flag;
		}
	}
}
