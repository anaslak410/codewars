
public class IntRecreateOne {

    public static String listSquared(long m, long n) {
        System.out.print(m + "," + n);
        String result = "";

        for (long i = m; i < n; i++) {

            long sq = 0;
            for (long j = 1; j <= i; j++) {
                if (i % j == 0) {
                    sq = sq + j * j;
                }
            }
            if (checkPerfectSquare(sq)) {
                result = result + "[" + i + ", " + sq + "], ";
            }
        }
        if (result != "")
            result = "[" + result.substring(0, result.length() - 2) + "]";

        else {
            result = "[]";
        }

        return result;

    }

    static boolean checkPerfectSquare(double x) {

        double sq = Math.sqrt(x);

        return ((sq - Math.floor(sq)) == 0);
    }

}