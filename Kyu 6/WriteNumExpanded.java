public class WriteNumExpanded {

    public static String expandedForm(int num) {

        String result = "";
        int zeroes = 1;

        while (num > 0) {

            if (num % 10 != 0) {
                int element = (num % 10) * zeroes;
                result = element + " + " + result;

                num = (num / 10) * zeroes * 10;
                zeroes = 1;
            }

            else {
                zeroes = zeroes * 10;
                num = num / 10;
            }
        }
        return result.substring(0, result.length() - 3);
    }
}