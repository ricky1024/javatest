public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
        if(s1==null && s2==null) return true;
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1!=len2) return false;
        if(len1==0) return true;
        //base case
        if(len1==1) {
            if(s1.equals(s2)) return true;
            else return false;
        }
        // check is s1 and s2 has same chars
        int sum1 = 0, sum2 = 0;
        for (int i=0; i<len1; i++){
            sum1 += (int)s1.charAt(i);
            sum2 += (int)s2.charAt(i);
        }
        if (sum1!=sum2){
            return false;
        }
        //partition for each length of i
        for(int i = 1; i < len1; i++) {
            String s1left = s1.substring(0,i);
            String s1right = s1.substring(i);
            //see if forward order is ok
            String s2left = s2.substring(0,i);
            String s2right = s2.substring(i);
            if(isScramble(s1left,s2left) && isScramble(s1right, s2right)) {
                return true;
            }
            //see if reverse order is ok
            s2left = s2.substring(len2-i);
            s2right = s2.substring(0, len2-i);
            if(isScramble(s1left, s2left) && isScramble(s1right, s2right)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    	ScrambleString ss = new ScrambleString();
    	String s1 = "abb";
    	String s2 = "bab";
    	System.out.println(ss.isScramble(s1,s2));
    }
}