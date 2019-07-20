public class SortColors {
	public void sortColors(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int p0 = 0;
		int p2 = nums.length - 1;
		int cur = 0;
		while (cur <= p2) {
			if (nums[cur] == 0) {
				int tmp = nums[p0];
				nums[p0++] = nums[cur];
				nums[cur++] = tmp;
			} else if (nums[cur] == 2) {
				int tmp = nums[p2];
				nums[p2--] = nums[cur];
				nums[cur] = tmp;
			}  else {
				cur++;
			}
		}
	}
}
