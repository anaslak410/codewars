import java.util.*;

public class SamePrimeFactor {
    public static int[] sameFactRev(int nMax) {

        List<Integer> result = new ArrayList<>();
        for (int i = 1089; i < nMax; i++) {
            int reverse = reverse(i);
            if (reverse == i) {
                continue;
            }
            if (primeNum(i).equals(primeNum(reverse))) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public static List<Integer> primeNum(int input) {

        List<Integer> primes = new ArrayList<>();
        if (input % 2 == 0) {
            primes.add(2);
            while (input % 2 == 0)
                input = input / 2;
        }
        for (int i = 3; i <= Math.sqrt(input); i += 2) {
            if (input % i == 0) {
                while (input % i == 0) {
                    input /= i;
                }
                primes.add(i);
            }
        }
        if (input > 2)
            primes.add(input);
        return primes;
    }
}