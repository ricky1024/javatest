public class Divide {
	public static int divide(int dividend, int divisor) {
        boolean neg = false;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            neg = true;
        }
        if(dividend==0) return 0;
        if(divisor==1) return dividend;
        if(divisor==-1) return -dividend;
        long u_dividend = Math.abs((long)dividend);
        long u_divisor = Math.abs((long)divisor);
        long original_divisor = u_divisor;
        if(u_dividend < u_divisor) return 0;
        long result = 0;
        long count = 1;
        while(u_divisor<u_dividend) {
            count<<=1;
            u_divisor<<=1;
            System.out.println(u_divisor+" "+count);
        }
        if(u_divisor==u_dividend) {
            result = count;
            System.out.println();
        } else {
            u_divisor >>= 1;
            count >>= 1;
            u_dividend -= u_divisor;
            result = count+divide((int)u_dividend, (int)original_divisor);
        }
        return neg?(int)(0-result):(int)result;
    }
    public static void main(String[] args) {
    	System.out.println(divide(-2147483648, -3));
    }
}