public class _4MedianoftwoSortedArrays {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     * time : o(log min(m, n)) space: o(1)
     */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
		int k = (nums1.length + nums2.length + 1) / 2;
		boolean isOdd = (nums1.length + nums2.length) % 2 == 0 ? false : true;
		int start = 0, end = nums1.length;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int nums1Num = mid;
			int nums2Num = k - nums1Num;
			int nums1LeftVal = nums1Num == 0 ? Integer.MIN_VALUE : nums1[nums1Num - 1];
			int nums1RightVal = nums1Num >= nums1.length ? Integer.MAX_VALUE : nums1[nums1Num];

			int nums2LeftVal = nums2Num == 0 ? Integer.MIN_VALUE : nums2[nums2Num - 1];
			int nums2RightVal = nums2Num >= nums2.length ? Integer.MAX_VALUE : nums2[nums2Num];

			if (nums1LeftVal > nums2RightVal) {
				//go left in nums1
				end = mid - 1;
			} else if (nums2LeftVal > nums1RightVal) {
				//go right in nums1
				start = mid + 1;
			} else if (nums1LeftVal <= nums2RightVal && nums2LeftVal <= nums1RightVal) {
				//find solution
				if (isOdd) {
					return Math.max(nums1LeftVal, nums2LeftVal) * 1.0;
				} else {
					return (Math.max(nums1LeftVal, nums2LeftVal)  + Math.min(nums1RightVal, nums2RightVal))* 1.0 / 2;
				}
			}
		}
		return -1.0;
	}
}
