import java.util.ArrayList;
import java.util.List;

public class _22GenerateParentheses {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     * time:o(2^n) space:o(n)
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        int l = 0;//( added so far
        int r = 0;//) added so far
        dfs(l, r, n, res, "");
        return res;
    }
    public void dfs(int l, int r, int n, List<String> res, String temp) {
        if (l + r == 2 * n) {
            res.add(temp);
            return;// base case
        }
        if (l < n) {
            dfs(l + 1, r, n, res, temp + "(");
        }
        if (l > r) {
            dfs(l, r + 1, n, res, temp + ")");
        }
    }
}
