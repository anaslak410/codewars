import java.util.function.*;

public class ReducingBySteps {
    public static long gcdi(long x, long y) {

        x = Math.abs(x);
        y = Math.abs(y);

        long gcd = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0)
                gcd = i;
        }
        return gcd;

    }

    public static long lcmu(long a, long b) {
        return Math.abs((a / gcdi(a, b)) * b);
    }

    public static long som(long a, long b) {
        return a + b;
    }

    public static long maxi(long a, long b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static long mini(long a, long b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static long[] operArray(BiFunction<Long, Long, Long> oper, long[] arr, long init) {
        long result[] = new long[arr.length];
        result[0] = oper.apply(arr[0], init);

        for (int i = 1; i < arr.length; i++) {
            result[i] = oper.apply(result[i - 1], arr[i]);
        }

        return result;
    }

}