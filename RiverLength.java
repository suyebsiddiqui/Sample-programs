
import java.util.ArrayList;

class RiverLength {
  // O(wh) time | O(wh) space
  public static ArrayList<Integer> riverSizes(int[][] matrix) {
    ArrayList<Integer> sizes = new ArrayList<Integer>();
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (visited[i][j]) {
          continue;
        }
        traverseNode(i, j, matrix, visited, sizes);
      }
    }
    return sizes;
  }

  public static void traverseNode(
      int i, int j, int[][] matrix, boolean[][] visited, ArrayList<Integer> sizes) {
    int currentRiverSize = 0;
    ArrayList<Integer[]> nodesToExplore = new ArrayList<Integer[]>();
    nodesToExplore.add(new Integer[] {i, j});
    while (!nodesToExplore.isEmpty()) {
      Integer[] currentNode = nodesToExplore.get(nodesToExplore.size() - 1);
      nodesToExplore.remove(nodesToExplore.size() - 1);
      i = currentNode[0];
      j = currentNode[1];
      if (visited[i][j]) {
        continue;
      }
      visited[i][j] = true;
      if (matrix[i][j] == 0) {
        continue;
      }
      currentRiverSize++;
      ArrayList<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited);
      for (Integer[] neighbor : unvisitedNeighbors) {
        nodesToExplore.add(neighbor);
      }
    }
    if (currentRiverSize > 0) {
      sizes.add(currentRiverSize);
    }
  }

  public static ArrayList<Integer[]> getUnvisitedNeighbors(
      int i, int j, int[][] matrix, boolean[][] visited) {
    ArrayList<Integer[]> unvisitedNeighbors = new ArrayList<Integer[]>();
    if (i > 0 && !visited[i - 1][j]) {
      unvisitedNeighbors.add(new Integer[] {i - 1, j});
    }
    if (i < matrix.length - 1 && !visited[i + 1][j]) {
      unvisitedNeighbors.add(new Integer[] {i + 1, j});
    }
    if (j > 0 && !visited[i][j - 1]) {
      unvisitedNeighbors.add(new Integer[] {i, j - 1});
    }
    if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
      unvisitedNeighbors.add(new Integer[] {i, j + 1});
    }
    return unvisitedNeighbors;
  }

  public static void main(String args[]) {

  int[][] input = {
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 1},

    };

  System.out.println(riverSizes(input));

  }
}