import java.util.*;
public class WordBreakII {
	static ArrayList<String> result = new ArrayList<String>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if(s==null || dict==null) return result;
        ArrayList<String> cur = new ArrayList<String>();
        dfs(s, dict, 0, cur);
        return result;
    }
    public void dfs(String s, Set<String> dict, int start, ArrayList<String> cur) {
        if(start==s.length()) {
            String ss = new String();
            for(int i = 0; i < cur.size()-1; i++) {
                ss += cur.get(i) + " ";
            }
            ss += cur.get(cur.size()-1);
            result.add(ss);
        } else {
            for(int i = start; i <= s.length(); i++) {
                String ss = s.substring(start, i);
                if(dict.contains(ss)) {
                    cur.add(ss);
                    dfs(s,dict,i,cur);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
    public static void main(String[] args) {
    	WordBreakII wb = new WordBreakII();
    	String s = "aaaaaaa";
    	Set<String> dict = new HashSet<String>();
    	dict.add("aaaa");
    	dict.add("aaa");
    	//dict.add("sand");
    	//dict.add("and");
    	//dict.add("dog");
    	wb.wordBreak(s, dict);
    	for(int i = 0; i < result.size(); i++) {
    		System.out.print(result.get(i)+",");
    	}
    	
    }
}