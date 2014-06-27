import java.util.*;
public class Subsets {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        int pos = 0;
        //length
        for(int i = 0; i <= S.length; i++) {
            ArrayList<Integer> localResult = new ArrayList<Integer>();
            dfs(S, localResult, i, pos);
        }
        return result;
    }
    public void dfs(int[] S, ArrayList<Integer> localResult, int length, int pos) {
        if(localResult.size()==length) {
            result.add(new ArrayList<Integer>(localResult));
            return;
        }
        for(int i = pos; i < S.length; i++) {
            localResult.add(S[i]);
            dfs(S, localResult, length, i+1);
            localResult.remove(localResult.size()-1);
        }
    }
    public static void main(String[] args) {
    	Subsets s = new Subsets();
    	int[] arr = {1,2,3};
    	ArrayList<ArrayList<Integer>> result = s.subsets(arr);
    	for(int i = 0; i < result.size(); i++) {
    		System.out.println(result.get(i));
    	}
    }
}