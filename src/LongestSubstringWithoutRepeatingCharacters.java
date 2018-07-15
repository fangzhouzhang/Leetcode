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
}
