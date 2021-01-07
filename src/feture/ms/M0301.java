
package feture.ms;

/**
 * @author lanshan
 */
public class M0301 {

    class TripleInOne {

        int[] stack;

        int[] index;

        int[] size;

        boolean error;

        int length;

        public TripleInOne(int stackSize) {
            if (stackSize <= 0) {
                error = true;
            } else {
                stack = new int[stackSize * 3];
                index = new int[3];
                size = new int[3];
                index[0] = -1;
                index[1] = stackSize - 1;
                index[2] = stackSize * 2 - 1;
                length = stackSize;
            }
        }

        private boolean checkParam(int num) {
            return error || num > 2 || num < 0;
        }

        public void push(int stackNum, int value) {
            if (checkParam(stackNum))
                return;
            if (size[stackNum] == length)
                return;
            stack[++index[stackNum]] = value;
            size[stackNum]++;
        }

        public int pop(int stackNum) {
            if (checkParam(stackNum))
                return -1;
            if (size[stackNum] <= 0)
                return -1;
            int res = stack[index[stackNum]--];
            size[stackNum]--;
            return res;
        }

        public int peek(int stackNum) {
            if (checkParam(stackNum))
                return -1;
            if (size[stackNum] <= 0)
                return -1;
            return stack[index[stackNum]];
        }

        public boolean isEmpty(int stackNum) {
            if (checkParam(stackNum))
                return true;
            return size[stackNum] == 0;
        }
    }
}
