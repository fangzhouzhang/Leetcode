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
    public int findMaxConsecutiveOnesII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int remainZero = 1;
        int globalMax = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length && remainZero >= 0) {
            if (nums[right] == 1) {
                right++;
            } else if (nums[right] == 0 && remainZero > 0) {
                right++;
                remainZero--;
            } else if (nums[right] == 0 && remainZero == 0) {
                if (right - left > globalMax) {
                    globalMax = right - left;
                }
                if (nums[left] == 0) {
                    remainZero++;
                }
                left++;
            }
        }
        return globalMax;
    }
}
