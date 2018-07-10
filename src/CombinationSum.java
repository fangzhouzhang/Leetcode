import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     * time:o(target / min_candidate ^ candidates.length)
     * space : o(n)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] count = new int[candidates.length];
        Arrays.sort(candidates);
        dfs(res, count, candidates, target, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] count, int[] candidates, int target, int level) {
        if (level == candidates.length) {
            if (target == 0) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < count.length; i++) {
                    for (int j = 0; j < count[i]; j++) {
                        temp.add(candidates[i]);

                    }
                }
                res.add(temp);
            }
            return;//base case
        }
        for (int i = 0; i <= target / candidates[level]; i++) {
            count[level] = i;
            dfs(res, count, candidates, target - candidates[level] * i, level + 1);
        }
    }
}
