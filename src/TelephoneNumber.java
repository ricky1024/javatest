public class TelephoneNumber {
	private static final int NUMBERLENGTH = 7;
	private final int[] telephoneNumber;
	private char[] result = new char[NUMBERLENGTH];
	public TelephoneNumber(int[] n) {
		telephoneNumber = n;
	}
	public void printWords() {
		printWords(0);
	}
	private void printWords(int current) {
		if(current==NUMBERLENGTH) {
			System.out.println(new String(result));
			return;
		}
		for(int i = 1; i<=3; i++) {
			result[current] = getCharKey(telephoneNumber[current],i);
			printWords(current+1);
			if(telephoneNumber[current]==0 || telephoneNumber[current]==1) {
				return;
			}
		}
	}
}