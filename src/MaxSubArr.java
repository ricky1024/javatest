public class MaxSubArr {
	public int maxSubArr(int[] arr) {
		int[] dp = new int[arr.length+1];
		dp[0] = 0;
		for(int i = 1; i < arr.length; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		return max(dp);
	}
	public int max(int[] arr) {
		int max = 0;
		for(int i:arr) {
			max = max>i?max:i;
		}
		return max;
	}
	public static void main(String[] args) {
		MaxSubArr ms = new MaxSubArr();
		int[] arr = {-2,-1,4,-1,3,1,2,-5};
		System.out.println(ms.maxSubArr(arr));
	}
}