import java.util.*;
public class LongestSubstring {
	//LTE when test case is big
	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int length = 0;
		//int index = 0;
		for(int i = 0; i < s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
				length++;
				if(length>result) {
					result = length;
					//index = i;
				}
			} else {
				i = map.get(s.charAt(i));
				length = 0;
				map.clear();
			}
		}
		//System.out.println(s.substring(index-result+1, index+1));
		return result;
	}

	public static void main(String[] args) {
		LongestSubstring ls = new LongestSubstring();
		String s = "12123456";
		System.out.println(ls.lengthOfLongestSubstring(s));
	}
}