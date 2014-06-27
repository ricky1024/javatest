import java.util.*;
public class SimplifyPath {
	public String simplifyPath(String path) {
        String[] sArr = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < sArr.length; i++) {
            if(sArr[i].equals("") || sArr[i]==null || sArr[i].equals(".")) continue;
            else if(sArr[i].equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(sArr[i]);
            }
        }
        System.out.println("haha");
        while(!stack.isEmpty()) {
        	System.out.println(stack.pop());
        }
        if(stack.isEmpty()) return "/";
        Stack<String> newStack = new Stack<String>();
        while(!stack.isEmpty()) {
            newStack.push(stack.pop());
        }
        String result = new String();
        while(!newStack.isEmpty()) {
            result += "/";
            result += newStack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
    	SimplifyPath sp = new SimplifyPath();
    	System.out.println(sp.simplifyPath("/.."));
    }
}