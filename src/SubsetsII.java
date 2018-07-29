import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * time : o(2^n)
     * space: call stack o(h)
     *          heap o(n)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        addNumber(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    public void addNumber(List<List<Integer>> res,
                          List<Integer> temp, int[] num, int level) {
        if (level == num.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(num[level]);
        addNumber(res, temp, num, level + 1);
        temp.remove(temp.size() - 1);

        while (level < num.length - 1
                && num[level + 1] == num[level]) {
            level++;
        }
        addNumber(res, temp, num, level + 1);
    }

}
