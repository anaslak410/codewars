import java.lang.Math;
import java.util.*;

public class SnakesLadders {

    private int pos1;
    private int pos2;
    private int tile;
    private Boolean turn;
    private Boolean gameOver;
    public HashMap<Integer, Integer> map;

    public SnakesLadders() {
        this.turn = true;
        this.pos1 = 0;
        this.pos2 = 0;
        this.gameOver = false;
        this.map = new HashMap<Integer, Integer>();
        this.tile = 0;

        for (int i = 1; i < 101; i++) {
            map.put(i, i);
        }

        map.put(2, 38);
        map.put(7, 14);
        map.put(8, 31);
        map.put(15, 26);
        map.put(28, 84);
        map.put(21, 42);
        map.put(36, 44);
        map.put(51, 67);
        map.put(71, 91);
        map.put(78, 98);
        map.put(87, 94);

        map.put(16, 6);
        map.put(46, 25);
        map.put(49, 11);
        map.put(62, 19);
        map.put(64, 60);
        map.put(74, 53);
        map.put(89, 68);
        map.put(92, 88);
        map.put(95, 75);
        map.put(99, 80);
    }

    public String play(int die1, int die2) {
        if (gameOver)
            return "Game over!";

        int n = turn ? 1 : 2;
        move(die1, die2);

        if (tile < 100)
            return "Player " + n + " is on square " + tile;
        else {
            gameOver = true;
            return "Player " + n + " Wins!";
        }
    }

    private void move(int die1, int die2) {
        int num = die1 + die2;
        int pos = turn ? pos1 + num - 100 : pos2 + num - 100;
        pos = 100 - Math.abs(pos);

        if (turn) {
            pos1 = map.get(pos);
        } else {
            pos2 = map.get(pos);
        }

        tile = turn ? pos1 : pos2;

        if (die1 != die2)
            turn = !turn;

    }
}