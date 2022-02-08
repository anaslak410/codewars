import java.math.BigInteger;
import java.util.Arrays;

public class DiffrentiatePolynomial {

    public static BigInteger differentiate(String equation, long x) {

        String[] constList = Arrays.stream(equation.split("(\\+)|(?=\\-)"))
                .map(i -> i.replaceAll("x", "*" + x))
                .toArray(String[]::new);

        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < constList.length; i++) {
            String expres = constList[i];

            if (expres.contains("*") || expres.contains("^")) {
                result = result.add(operat(expres));
            }
        }
        return result;
    }

    public static BigInteger operat(String input) {
        String[] equa = input.split("(\\*)|(\\^)");
        equa[0] = equa[0].equals("-") ? equa[0] = "-1" : equa[0];
        equa[0] = equa[0].isEmpty() ? equa[0] = "1" : equa[0];
        long[] expres = Arrays.stream(equa)
                .mapToLong(i -> Long.parseLong(i))
                .toArray();

        if (expres.length == 3) {
            BigInteger coef = BigInteger.valueOf(expres[0]);
            BigInteger variab = BigInteger.valueOf(expres[1]);
            int power = (int) expres[2];

            coef = coef.multiply(BigInteger.valueOf(power));
            return coef.multiply(variab.pow(power - 1));
        } else {
            return BigInteger.valueOf(expres[0]);
        }
    }
}