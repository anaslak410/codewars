import java.util.regex.*;
public class RemoveParentheses {
  
  public static String removeParentheses(final String str) {
    
    String result = str;

    Pattern pattern = Pattern.compile("\\([^\\).*\\(]*\\)");

    Matcher matcher = pattern.matcher(result);

    while (matcher.find()){
      result = matcher.replaceAll("");
      matcher = pattern.matcher(result);
    }

    return result;
  }

}