public class MaximalSquare {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     * Time : O(n^2) Space : O(n^2)
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        int[][] m = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    m[i][j] = 0;
                } else if (matrix[i][j] == 1 && (inbound(matrix, i - 1, j - 1, i - 1, j, i, j - 1))) {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, m[i - 1][j - 1]);
                    min = Math.min(min, m[i - 1][j]);
                    min = Math.min(min, m[i][j - 1]);
                    m[i][j] = 1 + min;
                } else {
                    m[i][j] = 1;
                }
                max = Math.max(max, m[i][j]);
                // System.out.print(" m[" + i + "][" + j + "]  " + m[i][j]);
            }
        }
        return max * max;
    }
    public boolean inbound(int[][] matrix, int i0, int j0, int i1, int j1, int i2, int j2) {
        if (i0 < 0 || i0 >= matrix.length || i1 < 0 || i1 >= matrix.length ||i2 < 0 || i2 >= matrix.length) {
            return false;
        }
        if (j0 < 0 || j0 >= matrix[0].length || j1 < 0 || j1 >= matrix[0].length || j2 < 0 || j2 >= matrix[0].length) {
            return false;
        }
        return true;
    }
}
