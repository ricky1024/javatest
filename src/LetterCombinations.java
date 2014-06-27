import java.util.*;
public class LetterCombinations {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        String[] number = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0) {
            return result;
        }
        int n = Integer.valueOf(digits.substring(0,1));
        System.out.println(n);
        for(int i = 0; i < number[n].length(); i++) {
            result.add(String.valueOf(number[n].charAt(i)));
        }
        if(digits.length()==1) {
            return result;
        }
        for(int i = 1; i < digits.length(); i++) {
            int k = Integer.valueOf(digits.substring(i,i+1));
            //int k = Integer.valueOf(String.valueOf(digits.charAt(i)));
            result = letterCombinations(result,number[k]);
        }
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + "  ");
        }
        System.out.println();
        return result;
    }
    public ArrayList<String> letterCombinations(ArrayList<String> ss, String s) {
        ArrayList<String> newArr = new ArrayList<String>();
        for(int i = 0; i < ss.size(); i++) {
            for(int j = 0; j < s.length(); j++) {
                newArr.add(ss.get(i)+s.charAt(j));
            }
        }
        return newArr;
    }
    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        lc.letterCombinations("22");
    }
}