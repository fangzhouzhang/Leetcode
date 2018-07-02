public class EditDistance {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     * Time : O(n^2) Space : O(n^2)
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int row = word1.length();
        int col = word2.length();
        int[][] m = new int[row + 1][col + 1];
        for (int i = 0; i < row + 1; i++) {
            //m[0][i] = i;
            m[i][0] = i;
        }
        for (int i = 0; i < col + 1; i++) {
            m[0][i] = i;
            // m[i][0] = i;
        }
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    m[i][j] = m[i - 1][j - 1];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                min = Math.min(m[i - 1][j - 1], Math.min(m[i][j - 1], m[i - 1][j]));
                m[i][j] = 1 + min;
            }
        }
        return m[row][col];
    }
}
