import java.util.*;
public class SurroundedRegions {
	Queue<Pair> queue = new ArrayDeque<Pair>();
    public void solve(char[][] board) {
        if(board.length==0) return;
        if(board[0].length==0) return;
        int row = board.length;
        int col = board[0].length;
        //first row and last row
        for(int i = 0; i < col; i++) {
            if(board[0][i]=='O') {
                bfs(board, 0, i);
            }
        }
        for(int i = 0; i < col; i++) {
            if(board[row-1][i]=='O') {
                bfs(board, row-1, i);
            }
        }
        //first col and last col
        for(int i = 0; i < row; i++) {
            if(board[i][0]=='O') {
                bfs(board, i, 0);
            }
        }
        for(int i = 0; i < row; i++) {
            if(board[i][col-1]=='O') {
                bfs(board, i, col-1);
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                }
                if(board[i][j]=='Y') {
                    board[i][j]='O';
                }
                System.out.print(board[i][j]);
            }
        }
    }
    public void bfs(char[][] board, int m, int n) {
        if(m<0 || m>=board.length || n<0 || n>=board[0].length || board[m][n]!='O') {
            return;
        }
        Pair pair = new Pair(m,n);
        queue.add(pair);
        board[m][n] = 'Y';
        while(queue.size()!=0) {
            pair = queue.poll();
            int i = pair.x;
            int j = pair.y;
            bfs(board, i-1, j);
            bfs(board, i+1, j);
            bfs(board, i, j-1);
            bfs(board, i, j+1);
        }
    }
    public static void main(String[] args) {
    	SurroundedRegions sr = new SurroundedRegions();
    	char[][] arr = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
    	sr.solve(arr);
    }
}
class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}