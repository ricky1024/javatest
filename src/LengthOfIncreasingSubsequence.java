public class LengthOfIncreasingSubsequence {
	public int length(int[] arr) {
		int[] dp = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			dp[i]=1;
			for(int j = 0; j < i; j++) {
				if(arr[j]<arr[i]) {
					dp[i] = dp[j]+1>dp[i]?dp[j]+1:dp[i];
				}
			}
		}
		int max = 0;
		for(int i = 0; i < dp.length; i++) {
			System.out.print(dp[i]+" ");
			max = max>dp[i]?max:dp[i];
		}
		System.out.println();
		return max;
	}
	public static void main(String[] args) {
		LengthOfIncreasingSubsequence l = new LengthOfIncreasingSubsequence();
		int[] lis = {10,22,9,33,21,50,41,60,80};
		System.out.println(l.length(lis));
	}
}