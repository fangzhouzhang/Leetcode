public class SpaceReplacement {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     * time:o(n) space:o(1)
     */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        //count space number
        int spaceNum = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                spaceNum++;
            }
        }
        int end = length + spaceNum * 2;
        int i = end - 1;
        int j = end - 1;

        while (j >= 0 && string[j] == 0) {
            j--;
        }
        while (j >= 0) {
            while (j >= 0 && string[j] == ' ') {
                string[i--] = '0';
                string[i--] = '2';
                string[i--] = '%';
                j--;
            }
            while (j >= 0 && string[j] != ' ') {
                string[i--] = string[j--];
            }
        }
        return end;
    }
}
