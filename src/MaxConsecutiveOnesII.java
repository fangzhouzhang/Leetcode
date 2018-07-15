public class MaxConsecutiveOnesII {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     * time : o(n) space:o(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        int remain_flip = 1;
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] == 1) {
                max = Math.max(r - l + 1, max);
                r++;
            } else {
                if (remain_flip > 0) {
                    remain_flip--;
                    max = Math.max(r - l + 1, max);
                    r++;
                } else {
                    while (l < r && nums[l] == 1) {
                        l++;
                    }
                    if (nums[l] == 0) {
                        remain_flip++;
                        l++;
                    }
                }
            }
        }
        return max;
    }
}
