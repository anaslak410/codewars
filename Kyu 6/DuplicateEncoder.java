public class DuplicateEncoder {
    static String encode(String word) {

        String word1 = word.toLowerCase();
        char[] cha = word1.toCharArray();
        char[] chas = word1.toCharArray();
        int test = 0;
        int pos = -1;
        for (char i : cha) {
            ++pos;
            for (char c : cha) {
                if (c == i) {
                    ++test;
                }
            }
            if (test > 1) {
                chas[pos] = ')';
            }
            else {
                chas[pos] = '(';
            }
            test = 0;
        }
        String result = String.valueOf(chas);
        return result;
    }
}