import java.util.*;

public class DirectionReduction {
  public static String[] dirReduc(String[] arr) {
    List<String> outputList = new ArrayList<String>();
    outputList.addAll(Arrays.asList(arr));
    while (dupRemover(outputList)) {
      dupRemover(outputList);
    }
    String[] finalArray = outputList.toArray(new String[0]);
    return finalArray;
  }

  public static boolean dupRemover(List<String> outputList) {
    boolean iterated = false;
    for (int i = 0, z = 1; z < outputList.size(); z++, i++) {
      String first = outputList.get(i);
      String second = outputList.get(z);

      if (first.equals("NORTH") && second.equals("SOUTH") || first.equals("SOUTH") && second.equals("NORTH")) {
        outputList.remove(z);
        outputList.remove(i);
        iterated = true;
      }
      if (first.equals("EAST") && second.equals("WEST") || first.equals("WEST") && second.equals("EAST")) {
        outputList.remove(z);
        outputList.remove(i);
        iterated = true;
      }
    }
    return iterated;
  }
}