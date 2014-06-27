public class IsPrime {
	public boolean isPrime(int n) {
		if(n<=1) return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		IsPrime p = new IsPrime();
		System.out.println(p.isPrime(2));
	}
}