public class Find1 {
	public int find1_Binary(int n) {
		int flag = 1;
		int count = 0;
		while(flag<=n) {
			//System.out.println(n & flag);
			if((n & flag)==flag) {
				count++;
			}
			flag = flag<<1;
		}
		return count;
	}

	//from 1 to n
	public int find1_Between(int n) {
		int count = 0;
		for(int i = 1; i <= n; i++) {
			count+= countOf1(i);
		}
		return count;
	}
	public int countOf1(int n) {
		int count = 0;
		while(n!=0) {
			if(n%10==1) {
				count++;
			}
			n = n/10;
		}
		return count;
	}
	public static void main(String[] args) {
		Find1 f = new Find1();
		System.out.println(f.find1_Binary(7));
		System.out.println(f.find1_Between(12));
	}
}