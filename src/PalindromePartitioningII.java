import java.util.*;
public class PalindromePartitioningII {
    /*
    Here the state is not too hard ----  minimum cut.   Define res[i] = the minimum cut from 0 to i in the string.
The result w =e need eventually is res[s.size()-1].
We know res[0]=0. Next we are looking for the optimal solution function f.
For example, let s = "leet".
f(0) = 0;  // minimum cut of str[0:0]="l", which is a palindrome, so not cut is needed.
f(1) = 1; // str[0:1]="le" How to get 1? 
                 f(1) might be:  (1)   f(0)+1=1, the minimum cut before plus the current char.
                                       (2)   0, if str[0:1] is a palindrome  (here "le" is not )
f(2) = 1; // str[0:2] = "lee" How to get 2?
                f(2) might be:   (1)  f(1) + 1=2
                                       (2)  0, if str[0:2] is a palindrome (here "lee" is not)
                                       (3)  f(0) + 1,  if str[1:2] is a palindrome, yes! 
f(3) = 2; // str[0:3] = "leet" How to get 2?
                f(3) might be:   (1)  f(2) + 1=2
                                       (2)  0, if str[0:3] is a palindrome (here "leet" is not)
                                       (3)  f(0) + 1,  if str[1:3] is a palindrome (here "eet" is not)
                                       (4)  f(1) + 1,  if str[2:e] is a palindrome (here "et" is not)
OK, output f(3) =2 as the result.

So, the optimal function is:

f(i) = min [  f(j)+1,  j=0..i-1   and str[j:i] is palindrome
                    0,   if str[0,i] is palindrome ]

The above algorithm works well for the smaller test cases, however for the big cases, it still cannot pass.
Why? The way we test the palindrome is time-consuming.

Also using the similar DP idea, we can construct the look-up table before the main part above, so that the palindrome testing becomes the looking up operation. The way we construct the table is also the idea of DP.
e.g.  mp[i][j]==true if str[i:j] is palindrome.
       mp[i][i]=true;
       mp[i][j] = true if str[i]==str[j] and (mp[i+1][j-1]==true or j-i<2 )  j-i<2 ensures the array boundary.

So, using this scheme to test the palindrome helps improve the efficiency and thus we can pass all the test cases. Details see the code below.
    */
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        //isPalindrome[]
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {   //substring form j to i
                if(s.charAt(i)==s.charAt(j) && (i-j < 2 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }
        //dp[]
        for(int i = 0; i < s.length(); i++) {
            int min = s.length();
            if(isPalindrome[0][i]) {
                dp[i]=0;
            } else {
                for(int j = 0; j < i; j++) {
                    if(isPalindrome[j+1][i] && min>dp[j]+1) {   ///
                        min = dp[j]+1;                           //find the min
                    }                                           ///
                }
                dp[i] = min;   //
            }
        }
        return dp[s.length()-1];
    }
    public static void main(String[] args) {
        PalindromePartitioningII p = new PalindromePartitioningII();
        String s = "aab";
        System.out.println(p.minCut(s));
    }
    //TLE
    /*
    ArrayList<Integer> num = new ArrayList<Integer>();
    int minResult = Integer.MAX_VALUE;
    public int minCut(String s) {
        if(isPalindrome(s)) {
            if(s.length()%2==0) {
                return 1;
            } else {
                return 2;
            }
        }
        int min = 0;
        palindrome(s,0, min);
        return minResult-1;
    }
    public void palindrome(String s, int start, int min) {
        if(start==s.length()) {
            minResult = minResult<min?minResult:min;
        } else {
            for(int i = start+1; i <= s.length(); i++) {
                String ss = s.substring(start, i);
                if(isPalindrome(ss)) {
                    min++;
                    palindrome(s, i, min);
                    min--;
                }
            }
        }
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    */
} 