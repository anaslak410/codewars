import java.util.*;

public class CodeWarsUser {
  public int rank;
  public int progress;
  private int rankIndex;
  private List<Integer> ranks;

  public CodeWarsUser() {
    rank = -8;
    progress = 0;
    ranks = Arrays.asList(-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8);
    rankIndex = 0;
  }

  public void incProgress(int rank) {
    if (rank == 0 || rank > 8 || rank < -8)
      throw new IllegalArgumentException();
    int tbaProgress = 0;
    int posRank = ranks.indexOf(rank);
    if (rankIndex == posRank) {
      tbaProgress = 3;
    } else if (rankIndex - 1 == posRank) {
      tbaProgress = 1;
    } else if (rankIndex - 1 > posRank) {
      return;
    } else {
      int dif = rankIndex - posRank;
      tbaProgress = (10 * (dif * dif));
    }
    checkProgress(tbaProgress);
  }

  private void checkProgress(int progressLeft) {
    int incRank = (progress + progressLeft) / 100;

    if (15 <= rankIndex + incRank) {
      this.progress = 0;
      rank = 8;
      rankIndex = 15;
    } else {
      progress = (progress + progressLeft) % 100;
      rank = ranks.get(rankIndex + incRank);
      rankIndex = rankIndex + incRank;
    }
  }
}