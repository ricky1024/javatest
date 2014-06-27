public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s2==null ||s3==null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        //boundary conditions, s1=="" or s2==""
        //when s2=="",just compare s1 and s3
        for(int i = 1; i <= s1.length(); i++) {
            if(s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0]) { //
                dp[i][0] = true;
            }
        }
        //when s1=="", just compare s2 and s3
        for(int i = 1; i <= s2.length(); i++) {
            if(s2.charAt(i-1)==s3.charAt(i-1) && dp[0][i-1]) { //
                dp[0][i] = true;
            }
        }
        for(int i = 1; i <= s1.length(); i++) {
            char c1 = s1.charAt(i-1);
            for(int j = 1; j <= s2.length(); j++) {
                char c2 = s2.charAt(j-1);
                char c3 = s3.charAt(i+j-1); //?
                if(c3==c1) {
                    dp[i][j] |= dp[i-1][j]; // difference between | and || : a | b, we need check both a and b
                                            //                               a || b, if a is true, return true directly, 
                }
                if(c3==c2) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }
        //print dp[][]
        for(int i = 0; i < dp.length; i++) {
        	for(int j = 0; j < dp[0].length; j++) {
        		System.out.print(dp[i][j]+"  ");
        	}
        	System.out.println();
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
    	InterleavingString is = new InterleavingString();
    	/*
    	String s1 = "";
    	String s2 = "caba";
    	String s3 = "cbba";
    	*/
    	String s1 = "abbc";
    	String s2 = "caba";
    	String s3 = "abcabbac";
    	System.out.println(is.isInterleave(s1, s2, s3));
    }
} 