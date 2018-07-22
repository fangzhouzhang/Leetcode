import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidIfBlocks {
    public void printBlocks(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        printIf(res, sb, n, 0, 0);
        for (String str : res) {
            System.out.println(str);
            System.out.println("**********************************************");
        }
        return;
    }

    private void printIf(List<String> res, StringBuilder sb, int n, int left, int right) {
        if (right == n) {
            res.add(format(sb));
            return;
        }
        if (left < n) {
            sb.append('(');
            printIf(res, sb, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            printIf(res, sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private String format(StringBuilder sb) {
        StringBuilder builder = new StringBuilder();
        int spaceNum = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                addSpace(builder, spaceNum);
                spaceNum += 2;
                builder.append("if {\n");
            } else {
                spaceNum -= 2;
                addSpace(builder, spaceNum);
                builder.append("}\n");
            }
        }
        return builder.toString();
    }

    private void addSpace(StringBuilder builder, int spaceNum) {
        for (int i = 0; i < spaceNum; i++) {
            builder.append(' ');
        }
    }
    @Test
    public void testValidIfBlocks() {
        printBlocks(3);
    }
}
