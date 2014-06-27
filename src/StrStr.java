public class StrStr {
	public static String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        if(haystack.length() == 0 && needle.length() == 0) {
            return "";
        }
        String result = new String();
        int len1 = haystack.length();
        int len2 = needle.length();
        for(int i = 0; i <= len1-len2; i++) {
            int p = i;
            int q = 0;
            while(p<len1 && q<len2) {
                if(haystack.charAt(p)==needle.charAt(q)) {
                    p++;
                    q++;
                    if(q==len2) {
                        result = haystack.substring(i);
                        return result;
                    }
                } else {
                    break;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
    	System.out.println(strStr("aaababbcdee", "abbcd"));
    	int n = 100>>4;
    	System.out.println(n);
    }
}