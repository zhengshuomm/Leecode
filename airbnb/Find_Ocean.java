import java.util.LinkedList;
import java.util.Queue;

public class Find_Ocean {
	// This code is shit.
	public void floodFill(char[][] board, int i, int j, char oldColor, char newColor) {
		if (board[i][j] != oldColor || board[i][j] == newColor) {
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i * board[0].length + j);
		board[i][j] = newColor;
		while (!queue.isEmpty()) {
			int pos = queue.poll();
			int m = pos / board[0].length;
			int n = pos % board[0].length;
			if (m + 1 < board.length && board[m + 1][n] == oldColor) {
				queue.add((m + 1) * board[0].length + n);
				board[m + 1][n] = newColor;
			}
			if (m - 1 >= 0 && board[m - 1][n] == oldColor) {
				queue.add((m - 1) * board[0].length + n);
				board[m - 1][n] = newColor;
			}
			if (n + 1 < board[0].length && board[m][n + 1] == oldColor) {
				queue.add(m * board[0].length + n + 1);
				board[m][n + 1] = newColor;
			}
			if (n - 1 >= 0 && board[m][n - 1] == oldColor) {
				queue.add(m * board[0].length + n - 1);
				board[m][n - 1] = newColor;
			}
		}
	}
}
