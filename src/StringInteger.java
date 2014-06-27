public class StringInteger {
	public static int strToInt(String str) {
		int i = 0, num = 0;
		boolean neg = false;
		if(str.charAt(i) == '-') {
			neg = true;
			i++;
		}
		while(i<str.length()) {
			num = num*10 + (str.charAt(i++)-'0');
		}
		if(neg) {
			return -num;
		}
		return num;
	}

	public static String intToStr(int n) {
		boolean neg = false;
		String result = new String();
		if(n<0) {
			neg = true;
			n = -n;
		} 
		if(n==0) {
			return new String("0");
		} 
		while(n>0) {
			result = result + (char)(n%10 +'0');
			n = n/10;
		}
		if(neg) {
			result = result+'-';
		}
		return reverse(result);
	}
	public static String reverse(String str) {
		int start = 0;
		int end = str.length()-1;
		char[] arr = str.toCharArray();
		char temp;
		while(start<end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return new String(arr);
	}

	public static void main(String[] args) {
		System.out.println(strToInt("23789"));
		System.out.println(intToStr(-128009));
	}
}