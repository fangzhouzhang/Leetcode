public class RemoveDuplicatesfromSortedArray {
    /*
     * @param nums: An ineger array
     * @return: An integer
     * time: o(n) space: o(1)
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null) {
            return -1;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[slow - 1]) {
                continue;
            }
            nums[slow++] = nums[fast];
        }
        return slow;
    }
}
