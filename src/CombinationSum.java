import java.util.*;

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
        Arrays.sort(candidates);
        dfs(res, new ArrayList<Integer>(), candidates, target, 0, new HashSet<Integer>());
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int level, Set<Integer> set) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (level == candidates.length) {
            return;
        }
        if (set.contains(candidates[level])) {
            dfs(res, temp, candidates, target, level + 1, set);
        } else {
            set.add(candidates[level]);
            for (int i = 0; i * candidates[level] <= target; i++) {
                for (int j = 1; j <= i; j++) {
                    temp.add(candidates[level]);
                }
                dfs(res, temp, candidates, target - candidates[level] * i, level + 1, set);
                for (int j = 1; j <= i; j++) {
                    temp.remove(temp.size() - 1);
                }
            }
            set.remove(candidates[level]);
        }

    }
}
