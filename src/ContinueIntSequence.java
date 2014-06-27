public class ContinueIntSequence {
	public void continueSequence(int n) {
		int small = 1;
		int big = 2;
		int middle = (1+n)/2;
		int sum = small + big;
		while(small<middle) {
			if(sum==n) {
				printSequence(small, big);
			}
			while(sum>n) {
				sum -= small;
				small++;
				if(sum==n) {
					printSequence(small, big);
				}
			}
			big++;
			sum+=big;
		}
	}
	public void printSequence(int small, int big) {
		for(int i = small; i <= big; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ContinueIntSequence obj = new ContinueIntSequence();
		obj.continueSequence(15);
	}
}