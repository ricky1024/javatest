public class TrappingRainWater {
	//time limit exceeded for large test case
	public int trap(int[] A) {
        int n = A.length;
        int m = 0;
        for(int i = 0; i < n; i++) {
            if(A[i]>m) {
                m = A[i];
            }
        }
        int[][] mat = new int[m][n];
        for(int j = 0; j < n; j++) {
            if(A[j]!=0) {
                for(int i = 0; i < A[j]; i++) {
                    mat[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		System.out.print(mat[i][j]+ " ");
        	}
        	System.out.println();
        }
        System.out.println();
        int sum = 0;
        for(int i = 0; i < m; i++) {
            int left = 0, right = 0;
            int count_1 = 0;
            for(int j = 0; j < n; j++) {
                if(mat[i][j]==1) {
                    count_1++;
                    if(count_1==2) {
                        right = j;
                        System.out.print(right+ "     ");
                    } else {
                        left = j;
                        System.out.print(left+ " ");
                    }
                }
                if(right>left) {
                    sum += right - left - 1;
                    count_1 = 0;
                    left = 0;
                    right= 0;
                }
                
            }
            System.out.println("sum:"+sum);
        }
        return sum;
    }
    public static void main(String[] args) {
    	TrappingRainWater trw = new TrappingRainWater();
    	int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println("result:"+trw.trap(A));
    }
}