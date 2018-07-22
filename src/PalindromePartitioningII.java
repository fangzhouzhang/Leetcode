public class PalindromePartitioningII {
    /**
     * @param s: A string
     * @return: An integer
     * time: o(n^2) space: o(n)
     */
    public int minCut(String s) {
        // write your code here
        char[] str = s.toCharArray();
        if (s.length() == 0 || s.length() == 1 || isPalindrome(str, 0, str.length - 1)) {
            return 0;
        }
        int[] m = new int[s.length()];
        m[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (isPalindrome(str, 0, i)) {
                m[i] = 0;
                continue;
            }
            int min = s.length();
            for (int j = 0; j < i; j++) {
                if (isPalindrome(str, j + 1, i)) {
                    min = Math.min(min, m[j] + 1);
                }
                if (min == 1) {
                    //m[i] = min;
                    break;
                }

            }
            m[i] = min;
        }
        return m[s.length() - 1];
    }
    public boolean isPalindrome(char[] arr, int start, int end) {
        int i = start;
        int j = end;
        while (i <= j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
