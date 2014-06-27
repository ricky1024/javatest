public class SplitRegex {
	public boolean isPalindrome(String s) {
        if(s==null) return false;
        if(s.length()==0 || s.length()==1) return true;
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        /*
        String[] ss = s.split("[^a-zA-Z0-9]");
        String str = new String();
        for(int i = 0; i < ss.length; i++) {
        	if(!ss[i].equals("")) {
        		str += ss[i];
        	}
        }
        */
        System.out.println(s);
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(left==right) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		s = s.toLowerCase();
		String[] ss = s.split("[^a-zA-Z0-9]");
		for(int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
		System.out.println(ss.length);
		System.out.println(s.toLowerCase());
		SplitRegex obj = new SplitRegex();
		System.out.println(obj.isPalindrome(s));
	}
}