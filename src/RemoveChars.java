public class RemoveChars {
	public static String removeChars(String str, String remove) {
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		boolean[] flag = new boolean[128];
		for(int i = 0; i < r.length; i++) {
			flag[r[i]] = true;
		}
		int des = 0;
		for(int i = 0; i < s.length; i++) {
			if(!flag[s[i]]) {
				s[des++] = s[i];
			}
		}
		return new String(s, 0, des);
	}

	public static void main(String[] args) {
		String str = "ni hao chen, suqiang";
		String remove = "aeiou";
		System.out.println(removeChars(str, remove));
	}
}