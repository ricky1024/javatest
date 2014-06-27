public class Knapsack {
	//0-1 knapsack
	public int[][] pack(int m,int n,int[] w,int[] p){
		//c[i][w]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
		int[][] c= new int[n+1][m+1];
		for(int i = 0;i<n+1;i++) {
			for(int j = 0;j<m+1;j++) {
				c[i][j] = 0;
			}
		}
		for(int i = 1;i<n+1;i++){
			for(int j = 1;j<m+1;j++){
				//当物品为i重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
				//(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
				//(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
				if(w[i-1]<=j){
					c[i][j] = Math.max(c[i-1][j], c[i-1][j-w[i-1]]+p[i-1]);
				}else
					c[i][j] = c[i-1][j];
			}
		}
		return c;
	}


	// 逆推法求出最优解
	public void printPack(int[][] c,int[] w,int m,int n) {

		int[] x = new int[n];
		//从最后一个状态记录c[n][m]开始逆推
		for(int i = n;i>0;i--) {
		//如果c[i][m]大于c[i-1][m]，说明c[i][m]这个最优值中包含了w[i-1](注意这里是i-1，因为c数组长度是n+1)
			if(c[i][m]>c[i-1][m]){
				x[i-1] = 1;
				m-=w[i-1];
			}
		}
		for(int j = 0;j<n;j++) {
			System.out.print(x[j] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		// 物品编号    重量    价值
		//    1         3       4
		//    2         4       5
		//    3         5       6
		int m = 10;
		int n = 3;
		int[] w = {3,4,5};
		int[] p = {4,5,6};
		Knapsack pack = new Knapsack();
		int[][] c = pack.pack(m, n, w, p);
		pack.printPack(c, w, m, n);
	}
}