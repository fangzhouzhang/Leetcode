import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutationII {
    /**
     * @param str: A string
     * @return: all permutations
     * time:o(n!) space:o(n)
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (str == "") {
            res.add(str);
            return res;
        }
        char[] arr = str.toCharArray();
        dfs(arr, res, 0);
        return res;
    }
    public void dfs(char[] arr, List<String> res, int level) {
        if (level == arr.length) {
            //res.add(new String(arr));
            res.add(String.valueOf(arr));
            return;
        }
        Set<Character> set_to_dedup = new HashSet<>();
        for (int i = level; i < arr.length; i++) {
            if (set_to_dedup.add(arr[i])) {
                swap(arr, level, i);
                dfs(arr, res, level + 1);
                swap(arr, level, i);
            }
        }
    }
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
