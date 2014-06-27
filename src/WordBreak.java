import java.util.*;
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        if(s==null || dict==null) {
            return false;
        }
        boolean[] flag = new boolean[s.length()+1];
        flag[0]=true;
        for(int i = 0; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(flag[j] && dict.contains(s.substring(j,i))) {
                    flag[i]=true;
                }
            }
        }
        for(int i = 0; i < s.length()+1; i++) {
        	System.out.print(flag[i]+" ");
        }
        return flag[s.length()];
    }
    public static void main(String[] args) {
    	WordBreak wb = new WordBreak();
    	String s = "leetcode";
    	Set<String> dict = new HashSet<String>();
    	dict.add("leet");
    	dict.add("code");
    	wb.wordBreak(s, dict);
    }
}