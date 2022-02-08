import java.util.*;

class FactDecomp {

    public static String decomp(int input) {

        String result = "";

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= input; i++) {

            if (checkForPrime(i)) {
                primes.add(i);
            }

        }

        int index = 0;
        int power = 1;
        int finals = 0;

        while (index < primes.size()) {

            int element = primes.get(index);
            int tests = (int) Math.pow(element, power);

            if (input / tests >= 1) {
                finals = finals + input / tests;
                power++;
            }

            else {

                if (finals == 1) {
                    result = result + element + " * ";
                }

                else {
                    result = result + element + "^" + finals + " * ";
                }

                index++;
                power = 1;
                finals = 0;

            }

        }

        System.out.print(result.replaceAll(".{3}$", ""));

        return result.replaceAll(".{3}$", "");
    }

    static boolean checkForPrime(int inputNumber) {

        boolean isItPrime = true;

        for (int i = 2; i <= inputNumber / 2; i++) {

            if ((inputNumber % i) == 0) {
                isItPrime = false;
                break;
            }
        }

        return isItPrime;

    }

}