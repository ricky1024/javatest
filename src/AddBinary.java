public class AddBinary {
	public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        int sum = 0;
        String result = new String();
        while(i>=0 && j>=0) {
            if(a.charAt(i)-'0' + b.charAt(j)-'0' + carry == 2) {
                sum = 0;
                carry = 1;
            } else if(a.charAt(i)-'0' + b.charAt(j)-'0' + carry == 3) {
                sum = 1;
                carry = 1;
            } else if(a.charAt(i)-'0' + b.charAt(j)-'0' + carry == 0) {
                sum = 0;
                carry = 0;
            } else {
                sum = 1;
                carry = 0;
            }
            result += sum;
            i--;
            j--;
        }
        if(i>j) {
            while(i>=0) {
                if(a.charAt(i)-'0' + carry == 2) {
                    sum = 0;
                    carry = 1;
                } else if(a.charAt(i)-'0' + carry == 0) {
                    sum = 0;
                    carry = 0;
                } else {
                    sum = 1;
                    carry = 0;
                }
                result += sum;
                i--;
            }
        } else if(i<j) {
            while(j>=0) {
                if(b.charAt(j)-'0' + carry == 2) {
                    sum = 0;
                    carry = 1;
                } else if(b.charAt(j)-'0' + carry == 0) {
                    sum = 0;
                    carry = 0;
                } else {
                    sum = 1;
                    carry = 0;
                }
                result += sum;
                j--;
            }
        }
        if(carry==1) {
            result += carry;
        }
        return reverse(result, 0, result.length()-1);
    }
    public String reverse(String s, int i, int j) {
        char[] arr = s.toCharArray();
        while(i<j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
    public static void main(String[] args) {
    	AddBinary ab = new AddBinary();
    	System.out.println(ab.addBinary("11","1"));
    }
}