import java.util.*;
import java.util.Arrays;

class GapInPrimes {
  public static long[] gap(int g, long m, long n) {

    long [] result = new long[2];

    List<Long> primes = new ArrayList<Long>();
    int i = -1;
    for (long num = m ; num < n ; num++) {

      if (primeNum(num)) {
        primes.add(num);
        i++;
      }

      if (primes.size() >= 2 && primes.get(i)-primes.get(i -1) == g) {
        result[0] = primes.get(i-1);
        result[1] = primes.get(i);
        break;
      }
    }

    if(result[1] == 0) { return null; }
    System.out.print(Arrays.toString(result) + "   ");
    return result;
  }

  public static boolean primeNum(long num) {

    for (int i = 2; i <= num / 2; ++i) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}