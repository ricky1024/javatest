public class OddBeforeEven {
	public void oddBeforeEven(int[] arr) {
		int i = 0;
		int j = arr.length-1;
		while(i<j) {
			while(i<j && arr[i]%2==1) {
				i++;
			}
			if(i<j) {
				arr[j--] = arr[i];
			}
			while(i<j && arr[j]%2==0) {
				j--;
			}
			if(i<j) {
				arr[i++] = arr[j];
			}
		}
	}
	public static void main(String[] args) {
		OddBeforeEven obj = new OddBeforeEven();
		int[] arr = {1,5,4,2,3,7,6,12,5,4,3,2};
		obj.oddBeforeEven(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}