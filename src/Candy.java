public class Candy {
	public int candy(int[] ratings) {
        int result = 0;
        int[] num = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++) {
            num[i] = 1;
        }
        for(int i = 0; i < ratings.length-1; i++) {
            if(ratings[i]<ratings[i+1]) {
                num[i+1] = num[i]+1<num[i+1]?num[i+1]:num[i]+1;
            }
        }
        for(int i = ratings.length-1; i > 0; i--) {
            if(ratings[i]<ratings[i-1]) {
                num[i-1] = num[i]+1<num[i-1]?num[i-1]:num[i]+1;
            }
        }
        for(int i = 0; i < ratings.length; i++) {
        	System.out.print(num[i] + " ");
            result += num[i];
        }
        System.out.println();
        return result;
    }
    public static void main(String[] args) {
    	Candy c = new Candy();
    	int[] ratings = {4,2,3,4,1};
    	System.out.println(c.candy(ratings));
    }
}