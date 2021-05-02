package feture.offer;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author lanshan
 */
public class Offer31 {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0)
            return true;
        if (pushed.length == 0)
            return false;
        if (popped.length == 0)
            return false;
        if (pushed.length != popped.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        Set<Integer> inStack = new HashSet<>();
        int pushIndex = 0;
        for (int i = 0; i < popped.length; i++) {
            if (stack.isEmpty() || !inStack.contains(popped[i])) {
                while (pushIndex < pushed.length) {
                    int t = pushed[pushIndex++];
                    stack.push(t);
                    inStack.add(t);
                    if (t == popped[i])
                        break;
                }
            }
            if (stack.isEmpty() || stack.peek() != popped[i])
                return false;
            stack.pop();
            inStack.remove(popped[i]);
        }
        return true;
    }
}
