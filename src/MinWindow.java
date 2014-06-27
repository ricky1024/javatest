import java.util.*;
public class MinWindow {

	public String minWindow(String S, String T) {
		if(S.length()<T.length() || S=="" || T=="") {
			return "";
		}
		if(T.length()==1) {
			for(int i = 0; i < S.length(); i++) {
				if(S.charAt(i)==T.charAt(0)) {
					return T;
				}
			}
			return "";
		}
        int[] mark = new int[S.length()];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++) {
        	map.put(T.charAt(i),i+1);
        }

        for(int i = 0; i < S.length(); i++) {
            if(map.containsKey(S.charAt(i))) {
                mark[i] = map.get(S.charAt(i));
            }
        }
        int p = 0, q = 0;
        int resultLeft = -1;
        int resultRight = -1;
        int minLength = Integer.MAX_VALUE;
        while(p<=q && q<mark.length) {
        	q++;
        	if(diffNum(mark, p, q)==T.length()) {
        		System.out.print("p: " + p + "  q:" + q + "   ");
        		if(q-p+1<minLength) {
        			resultLeft = p;
        			resultRight = q;
        			minLength = q-p+1;
        		}
        		p++;
        		while(p<=q && mark[p]==0) {
        			p++;
        		}
        	}
        }
        if(resultLeft == -1 && resultRight ==-1) {
        	return "";
        }
        return S.substring(resultLeft, resultRight);
    }
    public int diffNum(int[] arr, int left, int right) {
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i = left; i < right; i++) {
    		if(arr[i]!=0) {
    			set.add(arr[i]);
    		}
    	}
    	
    	Iterator<Integer> it = set.iterator();
    	while(it.hasNext()) {
    		int in = it.next();
    		System.out.print(in+"  ");
    	}
    	System.out.println();
    	
    	return set.size();
    }
    public static void main(String[] args) {
    	MinWindow mw = new MinWindow();
    	System.out.println(mw.minWindow("ADOBECODEBANC","ABC"));
    }
}