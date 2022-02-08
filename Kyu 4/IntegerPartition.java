import java.util.*;
public class IntegerPartition {
    public static String part(long n) {

    List<Integer> result = new ArrayList<>(prod((int)n));
    Collections.sort(result);

    int first = result.get(0);
    int second = result.get(result.size() - 1);
    long nums = 0;

    for (int i : result){
      nums = nums + i;
    }

    int size = result.size();
    double meanNum = (double) nums / size;
    float medianNum = 0;

    if (size % 2 != 0){
      medianNum = result.get(size / 2 );
    }
    else {
      medianNum = (float)(result.get((size/2)-1) + result.get(size/2)) / 2;
    }

    String mean = String.valueOf((double)Math.round((meanNum * 100))/100);

      if (mean.indexOf(".") == mean.length() - 2)
        mean = mean + "0";
    return "Range: " + (second - first) + " Average: " + mean + " Median: " + medianNum + "0";
  }
  public static int calcArray(int p[], int n)
  {
    int num = 1;
    for (int i = 0; i < n; i++){
      num = num * p[i]; }
    return num;
  }
  public static Set<Integer> prod(int n)
  {
    int[] p = new int[n];
    int k = 0;  
    p[k] = n;  
    
    Set<Integer> result = new HashSet<>();

    while (true)
    {
      
      result.add(calcArray(p, k+1));

      int rem_val = 0;
      while (k >= 0 && p[k] == 1)
      {
        rem_val += 1;
        k--;
      }

      if (k < 0)  return result;

      p[k]--;
      rem_val++;

      while (rem_val > p[k])
      {
        p[k+1] = p[k];
        rem_val = rem_val - p[k];
        k++;
      }

      p[k+1] = rem_val;
      k++;
    }
  }
}