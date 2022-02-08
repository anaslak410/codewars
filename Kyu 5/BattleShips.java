import java.util.Arrays;
import java.util.*;

public class BattleShips {

  public static Map<String, Double> damagedOrSunk(final int[][] board, final int[][] attacks) {

    Collections.reverse(Arrays.asList(board));

    Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
    numMap.put(1, 0);
    numMap.put(2, 0);
    numMap.put(3, 0);

    for (int i = 0; i < board.length; i++) {

      for (int j = 0; j < board[i].length; j++) {

        int elemInp = board[i][j];

        if (elemInp > 0) {
          int count = numMap.containsKey(elemInp) ? numMap.get(elemInp) : 0;
          numMap.put(elemInp, count + 1);
        }
      }
    }

    Map<Integer, Integer> numMap2 = new HashMap<Integer, Integer>(numMap);

    for (int i = 0; i < attacks.length; i++) {

      int x = attacks[i][0];
      int y = attacks[i][1];

      int elemInp = board[y - 1][x - 1];
      int count = numMap2.containsKey(elemInp) ? numMap2.get(elemInp) : 0;
      numMap2.put(elemInp, count - 1);

      board[y - 1][x - 1] = 0;

    }

    Map<String, Double> result = new HashMap<String, Double>();
    double sunk = .0;
    double damaged = .0;
    double notTouched = .0;
    double points = .0;

    for (int key : numMap.keySet()) {
      if (numMap.get(key) != 0) {
        if (numMap2.get(key) == 0) {
          sunk++;
          points++;
        } else if (numMap2.get(key) == numMap.get(key)) {
          notTouched++;
          points--;
        } else {
          damaged++;
          points = points + 0.5;
        }

      }
    }

    result.put("sunk", sunk);
    result.put("damaged", damaged);
    result.put("notTouched", notTouched);
    result.put("points", points);

    return result;
  }
}