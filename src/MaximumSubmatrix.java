public class MaximumSubmatrix {
    public int maxSubmatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] prefix = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                prefix[i][j + 1] = sum;
            }
        }
        /*for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length + 1; j++) {
                System.out.println(prefix[i][j]);
            }
            System.out.println("****************************");
        }*/
        int res = 0;
        int[] arr = new int[matrix.length];
        for (int j = 0; j < prefix[0].length; j++) {
            for (int k = j + 1; k < prefix[0].length; k++) {
                for (int i = 0; i < matrix.length; i++) {
                    arr[i] = prefix[i][k] - prefix[i][j];
//                    System.out.println("arr[i] " + arr[i] + " prefix[i][k] " + k + " " + prefix[i][k] + " prefix[i][j] " + j + " " +  + prefix[i][j]);
                }
//                System.out.println("******************");
                res = Math.max(res, maxSubArray(arr));
//                System.out.println("res max is  " + res + " maxSubArray(arr) " + maxSubArray(arr));
//                System.out.println("******************");
            }
        }
        return res;
    }


    public int maxSubArray(int[] nums) {
        // write your code here
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i + 1] = sum;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 1; j < prefix.length; j++) {
                if (prefix[j] - prefix[i] > max) {
                    max = prefix[j] - prefix[i];
                }
            }
        }
        return max;
    }
}
