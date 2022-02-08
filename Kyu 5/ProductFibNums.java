import java.util.*;

public class ProductFibNums { // must be public for codewars

    public static long[] productFib(long prod) {
        long[] result = new long[3];
        List<Long> sequenceFibo = new ArrayList<Long>();
        sequenceFibo.add(0L);
        sequenceFibo.add(1L);

        for (int i = 2; i < 50; i++) {
            long fib = sequenceFibo.get(i - 1);
            long fib2 = sequenceFibo.get(i - 2);
            long added = fib + fib2;
            sequenceFibo.add(added);
            if (fib * fib2 == prod) {
                result[0] = fib2;
                result[1] = fib;
                result[2] = 1;
                break;
            } else if (fib * fib2 > prod) {
                result[0] = fib2;
                result[1] = fib;
                result[2] = 0;
                break;
            }
        }
        return result;
    }
}