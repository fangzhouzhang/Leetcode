public class LongestCommonSubstring {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     * time: o(n^2) space: o(n^2)
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int max = 0;
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return max;
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
                    max = Math.max(max, m[row][col]);
                } else {
                    m[row][col] = 0;
                }
            }
        }
        return max;
    }
}
