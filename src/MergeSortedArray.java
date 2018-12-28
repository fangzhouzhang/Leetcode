public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1 = 0;
		int i2 = 0;
		int nonZeroNum = m;
		while (i1 < nonZeroNum && i2 < n) {
			if (nums1[i1] <= nums2[i2]) {
				i1++;
			} else {
				shiftBack(nums1, i1, nonZeroNum);
				nonZeroNum++;
				nums1[i1] = nums2[i2];
				i1++;
				i2++;
			}
		}
		while (i2 < n) {
			nums1[i1] = nums2[i2];
			i1++;
			i2++;
		}
	}
	private void shiftBack(int[] nums1, int i1, int nonZeroNum) {
		for (int i = nonZeroNum; i > i1; i--) {
			nums1[i] = nums1[i - 1];
		}
	}
}
