import java.util.*;
import java.util.function.Function;

public class MovesSquaredString {

    public static String rot(String strng) {
        StringBuilder input1 = new StringBuilder(strng);

        input1.reverse();
        String result = input1.toString();

        return result;
    }

    public static String selfieAndRot(String strng) {

        int count = strng.split("\n")[0].length();
        String dots = String.join("", Collections.nCopies(count, "."));

        strng = strng.replace("\n", dots + "\n");
        String result = strng + dots + "\n" + dots + rot(strng);

        return result;
    }

    public static String oper(Function<String, String> oper, String s) {

        return oper.apply(s);

    }

}