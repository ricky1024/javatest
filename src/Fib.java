public class Fib {
	public int fib(int n) {
		int n0 = 0;
		int n1 = 1;
		for(int i = 1; i < n; i++) {
			int temp = n1;
			n1 = n0 + n1;
			n0 = temp;
		}
		return n1;
	}
	public static void main(String[] args) {
		Fib f = new Fib();
		System.out.println(f.fib(4));
	}
}