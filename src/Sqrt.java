public class Sqrt {
	public int sqrt(int x) {
        return binarySearch(0, x, x);
    }
    public int binarySearch(int left, int right, long x) {
        if(left>right) {
            return -1;
        }
        int mid = (left+right)/2;
        if(mid*mid==x) {
            return mid;
        } else if(mid*mid>x) {
            return binarySearch(left, mid-1, x);
        } else {
            return binarySearch(mid+1, right, x);
        }
    }
    public static void main(String[] args) {
    	Sqrt s = new Sqrt();
    	System.out.println(s.sqrt(64));
    }
}