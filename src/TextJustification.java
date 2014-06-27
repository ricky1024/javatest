import java.util.*;
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        if(L==0) {
            result.add("");
            return result;
        }
        if(L==1) {
            for(int i = 0; i < words.length; i++) {
                result.add(words[i]);
            }
            return result;
        }
        if(words[0]=="") {
            String space = "";
            for(int i = 0; i < L; i++) {
                space += " ";
            }
            result.add(space);
            return result;
        }
        int i = 1;
        String s = words[0];
        while(i < words.length) {
            if((s + " " + words[i]).length() > L) {
                result.add(justify(s, L));
                s = words[i];
            } else {
                s = s + " " + words[i];
            }
            i++;
        }
        String space = "";
        for(int j = 0; j < L-s.length(); j++) {
            space += " ";
        }
        result.add(s+space);
        return result;
    }
    public String justify(String s, int L) {
        String[] sArr = s.split(" ");
        String result = new String();
        int allWordsLength = 0;
        for(int i = 0; i < sArr.length; i++) {
            allWordsLength += sArr[i].length();
        }
        int restLength = L - allWordsLength;
        if(sArr.length==1) {
            String space = "";
            for(int i = 0; i < restLength; i++) {
                space += " ";
            }
            result = sArr[0]+space;
            return result;
        }
        int eachGapLength = restLength/(sArr.length-1);
        if(restLength%(sArr.length-1)==0) {
            String space = "";
            for(int i = 0; i < eachGapLength; i++) {
                space += " ";
            }
            for(int i = 0; i < sArr.length-1; i++) {
                result += sArr[i] + space;
            }
            result += sArr[sArr.length-1];
        } else {
            int moreSpaceCount = restLength%(sArr.length-1);
            String space = "";
            for(int i = 0; i < eachGapLength; i++) {
                space += " ";
            }
            String moreSpace = space + " ";
            for(int i = 0; i < moreSpaceCount; i++) {
                result += sArr[i] + moreSpace;
            }
            for(int i = moreSpaceCount; i < sArr.length-1; i++) {
                result += sArr[i] + space;
            }
            result += sArr[sArr.length-1];
        }
        return result;
    }
    public static void main(String[] args) {
    	TextJustification tj = new TextJustification();
    	String[] arr = {"What","must","be","shall","be."};
    	System.out.println(tj.fullJustify(arr, 12));
    }
}