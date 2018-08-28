import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer
     * time:o() space:o(n)
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == "") {
            return 0;
        }
        int global_max = 0;
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < str.length) {
            if (!map.containsKey(str[r])) {
                map.put(str[r], 1);
                global_max = Math.max(r - l + 1, global_max);
                r++;

            } else {
                map.put(str[r], map.get(str[r]) + 1);
                if (map.get(str[r]) > 1) {
                    for (int i = l; i < r; i++) {
                        if (map.get(str[i]) > 1) {
                            map.put(str[i], 1);
                            l = i + 1;
                            break;
                        } else if (map.get(str[i]) == 1) {
                            map.put(str[i], 0);
                        }
                    }
                } else {
                    global_max = Math.max(r - l + 1, global_max);
                }
                r++;
            }
        }
        return global_max;
    }
    public int lengthOfLongestSubstringII(String s) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        boolean repeat = false;
        int slow = 0;
        int fast = 0;
        int res = 0;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                repeat = true;
            }
            fast++;

            while (repeat == true) {
                char start = s.charAt(slow);
                if (map.get(start) > 1) {
                    repeat = false;
                }
                map.put(start, map.get(start) - 1);
                slow++;
            }
            res = Math.max(res, fast - slow);
        }
        return res;
    }
}
