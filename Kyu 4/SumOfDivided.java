import java.util.Arrays;
import java.lang.Math;

public class SumOfDivided {
  public static String sumOfDivided(int[] l) {
    Arrays.sort(l);
    String result = "";

    int size = Math.abs(l[l.length - 1] + 1);
    System.out.println(size);

    int[] primes;
    if (Math.abs(l[0]) < size) {
      primes = findPrimes(size);
    } else {
      primes = findPrimes(Math.abs(l[0]));
    }

    int[] resultList = new int[primes.length];
    boolean[] stay = new boolean[primes.length];
    int limit = 0;
    for (int i = 0; i < l.length; i++) {
      limit = Math.abs(l[i]);
      int num = Arrays.binarySearch(primes, limit);
      if (num > -1) {
        resultList[num] = resultList[num] + l[i];
        stay[num] = true;
      }
      for (int j = 0; limit + 1 > primes[j] * 2; j++) {
        if (limit % primes[j] == 0) {
          resultList[j] = resultList[j] + l[i];
          stay[j] = true;
        }
      }
    }

    for (int i = 0; i < resultList.length; i++) {
      if (stay[i])
        result = result + "(" + primes[i] + " " + resultList[i] + ")";
    }
    return result;
  }

  public static int[] findPrimes(int input) {

    int[] result = new int[input - 2];

    for (int i = 2; i < result.length + 2; i++) {
      result[i - 2] = i;
    }

    Boolean found = false;
    int index = 0;

    while (!found) {
      int mum = result[index] + result[index];
      for (int i = index + result[index]; i < result.length; i = i + result[index]) {
        result[i] = 0;
      }
      for (int i = index + 1; i < result.length; i++) {
        if (result[i] != 0) {
          index = i;
          break;
        }
      }

      if (index + index > input / 2)
        break;
    }
    return Arrays.stream(result).filter(num -> num > 0).toArray();
  }
}