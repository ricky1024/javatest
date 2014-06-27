public class NQueens {
	public static final int N = 8;
	public static int[] a = new int[N+1];
	public static int count = 0;
	public static boolean place(int row, int column) {
		for(int i = 1; i < row; i++) {
			if(a[i] == column || Math.abs(row-i) == Math.abs(a[i]-column)) {
				return false;
			}
		}
		return true;
	}
	public static void backtrack(int row, int N) {
		if(row>N) {
			count++;
			System.out.println(count);
			char[][] result =  new char[N+1][N+1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					result[i][j]='.';
				}
			}
			for(int i = 1; i <=N; i++) {
				result[i][a[i]] = 'Q';
			}
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					System.out.print(result[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		} else {
			for(int i = 1; i <= N; i++) {
				if(place(row, i)) {
					a[row] = i;
					backtrack(row+1, N);
				}
			}
		}
	}
	public static void main(String[] args) {
		backtrack(1,N);
	}
}