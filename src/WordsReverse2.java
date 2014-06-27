public class WordsReverse2 {
	public static String WordsReverse2(String str) {
		char[] arr = str.toCharArray();
		String s = stringReverse(arr, 0, arr.length-1);
		int start = 0, end = 0;
		while(end<=arr.length-1) {
			if (arr[end] != ' ') {
				start = end;
				while(end<=arr.length-1 && arr[end]!=' ') {
					end++;
				}
				end--;
				stringReverse(arr, start, end);
			}
			end++;
		}
		return new String(arr, 0, arr.length);
	}

	public static String stringReverse(char[] arr, int start, int end) {
		char temp;
		while (end > start) {
			temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
		return new String(arr);
	}

	public static void main(String[] args) {
		String str = "hello world ni hao";
		System.out.println(WordsReverse2(str));
	}
}