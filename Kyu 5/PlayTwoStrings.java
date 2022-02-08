import java.util.*;

public class PlayTwoStrings {
    public static String workOnStrings(String a, String b) {

        return caseChanger(b, a) + caseChanger(a, b);

    }

    public static String caseChanger(String a, String b) {

        a = a.toLowerCase();
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : a.toCharArray()) {
            chars.add(c);
        }

        Set<Character> mySet = new HashSet<Character>(chars);

        StringBuffer newStr = new StringBuffer(b);

        for (char s : mySet) {
            int occurence = Collections.frequency(chars, s);

            if (occurence % 2 != 0) {

                for (int i = 0; i < b.length(); i++) {

                    int ascii = s - 32;
                    char sU = (char) ascii;

                    if (b.charAt(i) == s) {

                        newStr.setCharAt(i, Character.toUpperCase(b.charAt(i)));
                    }

                    else if (b.charAt(i) == sU) {

                        newStr.setCharAt(i, Character.toLowerCase(b.charAt(i)));
                    }
                }

            }

        }

        return newStr.toString();

    }
}