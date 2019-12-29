//Design a Tic-tac-toe game that is played between two players on a n x n grid.
//
//You may assume the following rules:
//
//A move is guaranteed to be valid and is placed on an empty block.
//Once a winning condition is reached, no more moves is allowed.
//A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
//Example:
//Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

//http://www.cnblogs.com/grandyang/p/5467118.html
public class Design_Tic_Tac_Toe_348 {
    int[] rows, cols;
    int diag, rev_diag, N;

    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.diag = 0;
        this.rev_diag = 0;
        this.N = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add; 
        cols[col] += add;
        diag += (row == col ? add : 0);
        rev_diag += (row == N - col - 1 ? add : 0);
        return (Math.abs(rows[row]) == N || Math.abs(cols[col]) == N || Math.abs(diag) == N || Math.abs(rev_diag) == N) ? player : 0;
    }
}
