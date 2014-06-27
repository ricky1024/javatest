public class WordsReverse {
	public static String wordsReverse(String str) {
		int globalScannerIndex, localScannerIndex, localEnd, writerIndex =0;
		char[] strArray = str.toCharArray();
		char[] result = new char[str.length()];
		globalScannerIndex = strArray.length-1;
		while (globalScannerIndex>=0) {
			if (strArray[globalScannerIndex]==' ') {
				result[writerIndex++] = strArray[globalScannerIndex--];
			} else {
				localEnd = globalScannerIndex;
				while(globalScannerIndex >= 0 && strArray[globalScannerIndex]!=' ') {
					globalScannerIndex--;
				}
				localScannerIndex = globalScannerIndex+1;
				while(localScannerIndex<=localEnd) {
					result[writerIndex++] = strArray[localScannerIndex++];
				}
			}
		}
		return new String(result);
	}

	public static void main(String[] args) {
		String str = "hello world, chen suqiang";
		System.out.println(wordsReverse(str));
	}
}