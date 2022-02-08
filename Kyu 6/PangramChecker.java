import java.util.*;

public class PangramChecker {
    public boolean check(String input) {
        input = input.toLowerCase().replaceAll("[^A-za-z]", "");
        String[] strSplit = input.split("");

        Set<String> listSet = new HashSet<String>(Arrays.asList(strSplit));
        return listSet.size() == 26;
    }
}