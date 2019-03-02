import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllValidPermutationsOfParenthesesII {
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        getPerm(res, 0, 0, 0, 0, 0, 0, l, m, n, new StringBuilder(), stack);
        return res;
    }

    public void getPerm(List<String> res,
                        int l_l, int m_l, int n_l,
                        int l_r, int m_r, int n_r,
                        int l, int m, int n,
                        StringBuilder sb, Stack<Character> stack) {
        if ( 2 * (l + m + n) == l_l + m_l + n_l + l_r + m_r + n_r) {
            res.add(new String(sb.toString()));
            return;
        }
        if (l_l < l) {
            stack.push('(');
            sb.append('(');
            getPerm(res, l_l + 1, m_l, n_l,
                    l_r, m_r, n_r,
                    l, m, n, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
            //stack.pop();
        }
        if (l_r < l_l && !stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
            sb.append(')');
            getPerm(res, l_l, m_l, n_l,
                    l_r + 1, m_r, n_r,
                    l, m, n, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (m_l < m) {
            stack.push('<');
            sb.append('<');
            getPerm(res, l_l, m_l + 1, n_l,
                    l_r, m_r, n_r,
                    l, m, n, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
            //stack.pop();
        }
        if (m_r < m_l && !stack.isEmpty() && stack.peek() == '<') {
            stack.pop();
            sb.append('>');
            getPerm(res, l_l, m_l, n_l,
                    l_r, m_r + 1, n_r,
                    l, m, n, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (n_l < n) {
            stack.push('{');
            sb.append('{');
            getPerm(res, l_l, m_l, n_l + 1,
                    l_r, m_r, n_r,
                    l, m, n, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
            //stack.pop();
        }
        if (n_r < n_l && !stack.isEmpty() && stack.peek() == '{') {
            stack.pop();
            sb.append('}');
            getPerm(res, l_l, m_l, n_l,
                    l_r, m_r, n_r + 1,
                    l, m, n, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}