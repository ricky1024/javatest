import java.util.*;
public class FirstOnce {
	public char firstOnce(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c,1);
			} else {
				map.put(c,map.get(c)+1);
			}
		}
		for(int i = 0; i < s.length(); i++) {
			if(map.get(s.charAt(i))==1) {
				return s.charAt(i);
			}
		}
		return '.';
	}
	public static void main(String[] args) {
		FirstOnce obj = new FirstOnce();
		String s = "abcdcaaee";
		System.out.println(obj.firstOnce(s));
	}
}