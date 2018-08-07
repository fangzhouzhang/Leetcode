public class LongestCommonSubsequence {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     * time: o(n^2) space: o(n^2)
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null
                || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[][] m = new int[A.length() + 1][B.length() + 1];
        for (int row = 0; row < A.length() + 1; row++) {
            m[row][0] = 0;
        }
        for (int col = 0; col < B.length() + 1; col++) {
            m[0][col] = 0;
        }
        for (int row = 1; row < A.length() + 1; row++) {
            for (int col = 1; col < B.length() + 1; col++) {
                if (A.charAt(row - 1) == B.charAt(col - 1)) {
                    m[row][col] = m[row - 1][col - 1] + 1;
                } else {
                    m[row][col] = Math.max(m[row - 1][col],
                            m[row][col - 1]);
                }
            }
        }
        return m[A.length()][B.length()];
    }
}
