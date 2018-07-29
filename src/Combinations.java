import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     * time : o(2^n)
     * space: call stack o(h)
     *          arr o(n)
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < k) {
            return res;
        }
        getCombination(res, new ArrayList<Integer>(), 0, k, arr);
        return res;
    }
    public void getCombination(List<List<Integer>> res,
                               List<Integer> temp, int level, int k,
                               int[] arr) {
        if (level == arr.length) {
            if (temp.size() == k) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(arr[level]);
        getCombination(res, temp, level + 1, k, arr);
        temp.remove(temp.size() - 1);

        getCombination(res, temp, level + 1, k, arr);
    }
}
