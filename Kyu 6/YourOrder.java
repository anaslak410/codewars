import java.util.*;

public class YourOrder {
    public static String order(String words) {
        // return empty string if input is empty
        String num = "";
        if (words.isEmpty()) {
            return num;
        }

        List<String> inputList = new ArrayList<String>(Arrays.asList(words.split(" ")));
        System.out.print(inputList);
        List<String> outputList = new ArrayList<String>();

        for (Integer z = 1; inputList.size() != outputList.size(); z++) {

            // will turn number currently looking for to string
            num = z.toString();
            for (Integer i = 0; i < inputList.size(); i++) {
                // current element
                String element = new String(inputList.get(i));
                if (element.contains(num)) {
                    outputList.add(z - 1, element);
                }
            }
        }
        String output = String.join(" ", outputList);

        return output;
    }
}