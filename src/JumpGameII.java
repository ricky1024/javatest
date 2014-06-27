public class JumpGameII {
	public int jump(int[] A) {
        int curCanReachTo = 0;
        int preCanReachTo = 0;
        int steps = 0;
        for(int i = 0; i < A.length; i++) {
            if(i > preCanReachTo) {
                preCanReachTo = curCanReachTo;
                steps++;
            }
            if(preCanReachTo==A.length-1) {
                return steps;
            }
            curCanReachTo = Math.max(curCanReachTo, i+A[i]);
        }
        return steps;
    }
    public static void main(String[] args) {
    	JumpGameII jg = new JumpGameII();
    	int[] A = {3,1,3,1,1,4};
    	System.out.println(jg.jump(A));
    }
}