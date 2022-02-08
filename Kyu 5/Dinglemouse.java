public class Dinglemouse {
  public static int[] sort(final int array[]) {

    if (array.length == 0)
      return new int[0];

    String[] result = new String[array.length];
    String[] oneDig = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    String[] twoDig = new String[] { "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
        "ninety" };

    for (int i = 0; i < array.length; i++) {
      int element = array[i];

      if (element >= 100) {
        int one = element % 10;
        int ten = (element % 100) / 10;
        int hundred = element / 100;

        if (element % 100 == 0) {
          result[i] = oneDig[hundred] + "-" + "hundred";
          continue;
        }
        if (element % 10 == 0) {
          result[i] = oneDig[hundred] + "-" + "hundred" + "-" + twoDig[ten - 1];
          continue;
        }
        if (ten == 1) {
          result[i] = oneDig[hundred] + "-" + "hundred" + "-" + oneDig[10 + one];
          continue;
        }
        if (ten == 0) {
          result[i] = oneDig[hundred] + "-" + "hundred" + "-" + oneDig[one];
          continue;
        }
        result[i] = oneDig[hundred] + "-" + "hundred" + "-" + twoDig[ten - 1] + "-" + oneDig[one];
      } else if (element > 19) {
        int ten = element / 10;

        if (element % 10 == 0) {
          result[i] = twoDig[ten - 1];
          continue;
        }

        int one = element % 10;
        result[i] = twoDig[ten - 1] + "-" + oneDig[one];
      } else
        result[i] = oneDig[element];
    }

    return convert(result, array);
  }

  public static int[] convert(String[] alphabet, int[] numeric) {
    Boolean iterated = true;
    while (iterated) {
      iterated = false;
      for (int i = 0; i < alphabet.length - 1; i++) {
        if (alphabet[i].compareTo(alphabet[i + 1]) > 0) {

          iterated = true;
          String temp = alphabet[i];
          alphabet[i] = alphabet[i + 1];
          alphabet[i + 1] = temp;

          int tempNum = numeric[i];
          numeric[i] = numeric[i + 1];
          numeric[i + 1] = tempNum;
        }

      }
    }
    return numeric;
  }
}