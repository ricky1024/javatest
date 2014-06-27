public class WildcardMatch {
	public boolean isMatch(String s, String p) {
        if((s==null && p==null) || (s=="" && p=="")) {
            return true;
        }
        int i = 0, j = i;
        int starPos = -1;
        int sPos = -1;
        while(i < s.length()) {
                if(j < p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')) {
                    i++;j++;
                    System.out.print("1");
                    continue;
                }
                if(j < p.length() && p.charAt(j)=='*') {
                    starPos = j;
                    sPos = i;
                    j++;
                    System.out.print("2");
                    continue;
                }
                if(starPos!=-1) {
                    i = ++sPos;
                    j = starPos+1;
                    System.out.print("3");
                    continue;
                }
                System.out.print("4");
                return false;
        }
        while(j < p.length()) {
        	if(p.charAt(j)=='*') {
        		j++;
        	}
        	System.out.print("5");
        }
        System.out.println("i="+i+",j="+j);
        return j==p.length()?true:false;
    }

    public static void main(String[] args) {
    	WildcardMatch wm = new WildcardMatch();
    	System.out.println(wm.isMatch("aa","*"));
    }
}