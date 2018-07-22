import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        //detailed report seen in the google doc
        if (s.length() == 0) {
            return true;
        }
        int maxLength = getMaxLength(dict);
        boolean[] M = new boolean[s.length() + 1];
        M[0] = true;
        for (int i = 1; i < M.length; i++) {
            /*if (dict.contains(s.substring(0, i))) {
                M[i] = true;
                continue;
            }*/
            //for (int j = 1; j <= maxLength && j < i; j++) {
            for (int j = i - 1; j >= i - maxLength && j >= 0; j--) {
                if (M[j] == true && dict.contains(s.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[s.length()];
    }
    private int getMaxLength(Set<String> dict){
        int max = 0;
        for(String s : dict){
            max = Math.max(max,s.length());
        }
        return max;
    }
    @Test
    private void test() {
        String s = "";
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        dict.add("d");
        dict.add("e");
        dict.add("f");
        dict.add("g");
        wordBreak(s, dict);
    }
}
