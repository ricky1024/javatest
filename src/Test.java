
public class Test {
    public static void main(String[] args) {
		  /*
      int result = 10;
		  int count = 1;  
  		int i = 1;  
  		while(true){  
    		  if(result&i==1){  
       			  break;  
     		   }
     		   result>>1;  
     		   count<<1;  
  		}  
		  System.out.println(result);
      */
      String s = "abc";
      System.out.println(swap(s,0,2));
      System.out.println(reverse(s,0,1));

      char c = 't';
      System.out.println(c-'0');
      System.out.println(0+'0');
      System.out.println(0+'9');
      System.out.println(7>>1);
      String ss = "/..//../";
      String[] arr = ss.split("/");
      for(String sss:arr) {
          System.out.print(sss);
      }
      //ASCII
      char a=1;
      while(a<128){
          a++;
          System.out.print(a+""+(int)a + " ");
      }
	  }
    public static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
    public static String reverse(String s, int i, int j) {
        char[] arr = s.toCharArray();
        while(i<=j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;j--;
        }
        return new String(arr);
    }
	
}