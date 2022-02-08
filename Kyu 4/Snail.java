import java.util.*;
import java.util.stream.*;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Array;

public class Snail {

    public static int[] snail(int[][] array) {
          List<Integer> result = new ArrayList<>();

    while (array.length > 0) {

      for (int i = 0 ; i < array.length + 1 ; i++){

        if (i == 0 ){
          int[] element = (int[])Array.get(array,i);
          for (int j : element){
            result.add(j);
          }
          array = ArrayUtils.remove(array, 0);
        }
        
        else {
          int x = array[i-1][array[i-1].length - 1];
          result.add(x);
          array[i-1] = ArrayUtils.remove(array[i-1], array[i-1].length - 1);
        }
      }

      int size = array.length;
      for (int i = array.length - 1 ; i > -1 ; i--){

        if (i == size - 1){

          int[] element = (int[])Array.get(array,i);

          for (int j = element.length - 1 ; j > -1 ; j--){
            int num = (int)Array.get(element,j);
            result.add(num);
          }

          array = ArrayUtils.remove(array, array.length - 1);
        }

        else {
          int x = array[i][0];
          result.add(x);
          array[i] = ArrayUtils.remove(array[i], 0);
        }
      }
    }

    int[] output = result.stream()
      .mapToInt(Integer::intValue)
      .toArray();

    return output;
   } 
}