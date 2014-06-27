public class CombineString {
	public static void combine(String str) {
		char[] in = str.toCharArray();
		StringBuffer out = new StringBuffer();
		allCombine(in, out, 0);
	}
	public static void allCombine(char[] in, StringBuffer out, int start) {
		for(int i = start; i < in.length; i++) {
			out.append(in[i]);
			System.out.println(out);
			allCombine(in, out, i+1);
			out.setLength(out.length()-1);
		}
	}
	public static void main(String[] args) {
		String str = "ABC";
		combine(str);
	}
}