import java.util.*;

class StepInPrimes {

    public static long[] step(int g, long m, long n) {
        long[] result = new long[2];

        List<Long> primes = new ArrayList<>();

        boolean stop = false;
        for (long i = m; i < n; i++) {

            if (i % 2 != 0 && isPrime(i)) {
                for (int j = primes.size() - 1; j > -1; j--) {
                    if (i - primes.get(j) == g) {

                        result[0] = primes.get(j);
                        result[1] = i;

                        stop = true;
                        break;
                    }
                }

                if (stop) {
                    break;
                }

                primes.add(i);
            }
        }

        if (result[0] == 0)
            return null;

        return result;
    }

    public static boolean isPrime(long input) {
        if (input == 1 || input == 0) {
            return false;
        }
        for (long j = 2; j < input; j++) {
            if (input % j == 0) {
                return false;
            }
        }
        return true;

    }

}