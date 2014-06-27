import java.util.*;
public class PermutationSequence {
	//LTE when n=9
	/*
	public String getPermutation(int n, int k) {
        if(n==1) {
            return new String("1");
        }
        if(n==2) {
            return k==1?new String("12"):new String("21");
        }
        String s = new String();
        for(int i = 0; i < n; i++) {
            s += i+1;
        }
        System.out.println(s);
        int count = 1;
        while(nextPermutation(s)!=s) {
            if(count==k) {
                return s;
            }
            count++;
            s = nextPermutation(s);
        }
        return s;
    }
    public String nextPermutation(String s) {
        int firstDown = -1;
        for(int i = s.length()-2; i>=0; i--) {
            if(s.charAt(i)<s.charAt(i+1)) {
                firstDown = i;
                break;
            }
        }
        if(firstDown==-1) {
            return s;
        }
        int minLarger = -1;
        for(int i = s.length()-1; i > firstDown; i--) {
            if(s.charAt(firstDown)<s.charAt(i)) {
                minLarger = i;
                break;
            }
        }
        s = swap(s, firstDown, minLarger);
        System.out.println("swap:"+s);
        s = reverse(s, firstDown+1, s.length()-1);
        System.out.println("reverse:"+s);
        return s;
    }
    public String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
    public String reverse(String s, int i, int j) {
        char[] arr = s.toCharArray();
        while(i<=j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;j--;
        }
        return new String(arr);
    }
    */

    public String getPermutation(int n, int k) {
        if(n==1) {
            return "1";
        }
        String result = new String();
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            num.add(i);
        }
        while(n>=1) {
            int index = k / factorial(n-1);
            k = k % factorial(n-1);
            result += num.get(index);
            num.remove(index);
            n--;
        }
        return result;
    }
    public int factorial(int n) {
        int result = 1;;
        while(n>=1) {
            result *= n;
            n--;
        }
        return result;
    }
    public static void main(String[] args) {
    	PermutationSequence ps = new PermutationSequence();
    	System.out.println(ps.getPermutation(3,5));
    }
}