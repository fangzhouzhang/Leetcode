import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /**time o(2^n) space o(n)
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null ) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int index, int[] nums) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            //key  i + 1 VS i++ 后者有可能会导致遍历的数据减少
            helper(res, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     * time o(2^n) space o(n)
     */
    public List<List<Integer>> subsets1(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, 0, res, temp);
        return res;
    }
    public void dfs(int[] nums, int level, List<List<Integer>> res, List<Integer> temp) {
        if (level == nums.length) {
            res.add(new ArrayList<>(temp));
            return;//base case
        }
        temp.add(nums[level]);
        dfs(nums, level + 1, res, temp);
        temp.remove(temp.size() - 1);

        dfs(nums, level + 1, res, temp);
    }
}
