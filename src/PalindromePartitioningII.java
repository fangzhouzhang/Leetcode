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
	public int minCutI(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		if (isPalin(s)) {
			return 0;
		}
		Integer[] mem = new Integer[s.length()];
		return dfs(s, 0, mem);
	}
	private boolean isPalin(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	private int dfs(String s, int level, Integer[] mem) {
		if (mem[level] != null) {
			return mem[level];
		}
		//if arrive at last char and all parts are palindrome, return 0
		if (level == s.length() - 1) {
			mem[level] = 0;
			return 0;
		}
		if (isValid(s, level, s.length() - 1)) {
			mem[level] = 0;
			return 0;
		}

		int temp = Integer.MAX_VALUE;

		//try to cut at palindrome
		for (int i = level; i < s.length() - 1; i++) {
			if (isValid(s, level, i)) {
				temp = Math.min(temp, dfs(s, i + 1, mem) + 1);
			}
		}
		mem[level] = temp;
		return temp;
	}
	private boolean isValid(String s, int start, int end) {
		// System.out.println(s.substring(start, end + 1));
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
