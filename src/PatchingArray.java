public class PatchingArray {
	public int minPatches(int[] nums, int n) {
		long miss = 1;
		int i = 0;
		int res = 0;
		while ( miss <= n) {
			if (i < nums.length && nums[i] <= miss) {
				miss += nums[i++];
			} else {
				res++;
				miss += miss;
			}
		}
		return res;
	}
}
