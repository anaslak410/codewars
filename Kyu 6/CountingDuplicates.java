import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
    String tempArray[] = text.toLowerCase().split("");
    Arrays.sort(tempArray);
    String finals = String.join("", tempArray);

    Pattern pattern = Pattern.compile("(\\w)\\1+");
    Matcher matcher = pattern.matcher(finals);
    long num = matcher.results().count();

    int result = (int) num;
    return result;
  }

}