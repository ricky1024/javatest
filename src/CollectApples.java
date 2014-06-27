public class CollectApples {
	//2D DP
	public int maxApples(int[][] table) {
		int[][] sum = new int[table.length][table[0].length];
		sum[0][0] = table[0][0];
		for(int i = 1; i < table.length; i++) {
			sum[i][0] = table[i][0]+sum[i-1][0];   //first column
		}
		for(int j = 1; j < table[0].length; j++) {
			sum[0][j] = table[0][j]+sum[0][j-1];   //first row
		}
		for(int i = 1; i < table.length; i++) {
			for(int j = 1; j < table[0].length; j++) {
				sum[i][j] = table[i][j]+Math.max(sum[i-1][j],sum[i][j-1]); //DP
			}
		}
		printMat(sum);
		return sum[table.length-1][table[0].length-1];
	}
	public void printMat(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		CollectApples ca = new CollectApples();
		int[][] arr = {{1,2,4,1,3},
					   {3,5,1,2,1},
					   {2,1,2,3,2},
					   {3,2,3,1,2}};
		System.out.println(ca.maxApples(arr));
	}
}