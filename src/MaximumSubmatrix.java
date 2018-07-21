public class MaximumSubmatrix {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     * time: o(n^3) space: o(n^2)
     */
    public int maxSubmatrix(int[][] matrix) {
        // write your code here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //build prefixSum array
        int[][] prefixSum = new int[matrix[0].length][matrix.length + 1];
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length + 1; row++) {
                if (row == 0) {
                    prefixSum[col][row] = 0;
                } else {
                    prefixSum[col][row] = matrix[row - 1][col] + prefixSum[col][row - 1];
                }
            }
        }
        /*for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[0].length; j++) {
                System.out.print(" " + prefixSum[i][j] + " ");
            }
            System.out.println();
        }*/
        int[] input = new int[matrix[0].length];
        int global_max = Integer.MIN_VALUE;
        for (int upper = 0; upper < matrix.length; upper++) {
            for (int lower = upper; lower < matrix.length; lower++) {
                for (int i = 0; i < matrix[0].length; i++) {
                    input[i] = prefixSum[i][lower + 1] - prefixSum[i][upper];
                }
                global_max = Math.max(maxSubArray(input), global_max);
            }
        }
        return global_max;
    }
    public int maxSubArray(int[] nums) {
        // write your code here
        //time: o(n)
        if (nums.length == 0) {
            return -1;
        }
        int[] m = new int[nums.length];
        m[0] = nums[0];
        int global_max = Math.max(Integer.MIN_VALUE, m[0]);
        for (int i = 1; i < nums.length; i++) {
            if (m[i - 1] < 0) {
                m[i] = nums[i];
            } else {
                m[i] = nums[i] + m[i - 1];
            }
            global_max = Math.max(global_max, m[i]);
        }
        return global_max;
    }
}
