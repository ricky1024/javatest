public class LongestLengthByChanging1Digit {
	public int longestLength(int[] arr) {
		int[] length = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			length[i]=1;
		}
		int firstTime = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j <arr.length-1; j++) {
				if(arr[i]==arr[j+1]) {
					length[i]++;
				} else {
					if(firstTime==0) {
						length[i]++;
						firstTime = 1;
					} else {
						firstTime=0;
						break;
					}
				}
			}
		}
		return max(length);
	}
	public int max(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			max = max>arr[i]?max:arr[i];
		}
		return max;
	}
	public static void main(String[] args) {
		LongestLengthByChanging1Digit obj = new LongestLengthByChanging1Digit();
		int[] arr = {1,1,0,1,0,0};
		System.out.println(obj.longestLength(arr));
	}
}