import java.util.*;
public class EvaluateRPN {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(Integer.valueOf(tokens[i]));
                System.out.print(stack.peek()+" ");
            } else {
                if(stack.size()>=2) {
                	int result = 0;
                    int a = stack.pop();
                    int b = stack.pop();
                    if(tokens[i].equals("+")) {
                        result = b+a;
                    } else if(tokens[i].equals("-")) {
                        result = b-a;
                    } else if(tokens[i].equals("*")) {
                        result = b*a;
                    } else if(tokens[i].equals("/")) {
                        result = b/a;
                    }
                    stack.push(result);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
    	EvaluateRPN obj = new EvaluateRPN();
    	String[] s = {"3","-4","+"};
    	System.out.println(obj.evalRPN(s));
    }
}