import java.util.*;

public class _46Permutations {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute1(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(nums, res, 0);
        return res;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void dfs(int[] nums, List<List<Integer>> res, int level) {
        if (level == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            res.add(temp);
            return;//base case
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            dfs(nums, res, level + 1);
            swap(nums, level, i);
        }
    }
}
