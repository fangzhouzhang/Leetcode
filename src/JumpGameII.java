public class JumpGameII {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        /**
         * M[i] means the minimum number needed for i-th element to reach (A.length - 1)-th element
         * array A = [2,3,1,1,4]
         *    M[i] = [2,1,2,1,0]
         * Induction rule:
         *   M[i] = 1 + min(M[i + 1], ..., M[i + Input[i]])
         * Example: all the reachable element in both input and M
         * Input[i] Input[i + 1] ... Input[i + Input[i]]
         * M[i]     M[i + 1]     ... M[i + Input[i]]
         * whatever you move, at least one step you must move from this point
         * Time : O(n^2) Space: O(n)
         */
        int[] M = new int[A.length];
        M[A.length - 1] = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] + i >= A.length - 1) {
                M[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= A[i]; j++) {
                    if (M[i + j] < min) {
                        min = M[i + j];
                    }
                }
                M[i] = 1 + min;
            }
        }
        return M[0];
    }

	public int jump2(int[] nums) {
		if (nums.length == 0) return 0;
		//dp[i] means min number from index i to reach destination
		Integer[] dp = new Integer[nums.length];
		dp[dp.length - 1] = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] == 0) continue;
			int min = Integer.MAX_VALUE;
			for (int step = 1; step <= nums[i]; step++) {
				if (step + i < nums.length && dp[step + i] != null) {
					min = Math.min(min, dp[step + i] + 1);
				}
			}
			if (min != Integer.MAX_VALUE) dp[i] = min;
		}
		return dp[0];
	}
}
