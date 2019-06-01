package l201904;

/**
 * @author lanshan
 */
public class LeetCode5 {

    public static final boolean DOWN = true;

    public static final boolean UP = false;
    /**
     * "LEETCODEISHIRING" numRows = 3
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     *"LCIRETOESIIGEDHN"
     *
     * 3 1 3 1 3 1
     *
     * s = "LEETCODEISHIRING", numRows = 4
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * "LDREOEIIECIHNTSG"
     *
     * 4 1 1 4 1 1 4 1 1 4 1 1
     */
    public String convert(String s, int numRows) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int other = numRows - 2;
        int total = numRows + other;
        int col = 1 + other;
        int out = length / total;
        col = out*col;
        int out1 = length % total;
        if (out1 <= numRows) {
            col ++;
        } else {
            col += (out1 - numRows) + 1;
        }
        char[][] matrix = new char[numRows][col];
        build(matrix, chars, numRows);
        return print(matrix);
    }

    public void build(char[][] matrix, char[] chars, int numRows) {
        boolean mode = DOWN;
        int i=0,j=0;
        for (char a : chars) {
            if (i < 0) {
                i = 1;
                j--;
                mode = DOWN;
            }
            if (i >= numRows) {
                i-=2;
                j++;
                mode = UP;
            }
            if (mode == DOWN) {
                matrix[i++][j] = a;
            } else {
                matrix[i--][j++] = a;
            }
        }
    }

    public String print(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]!='\u0000') {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode5 l = new LeetCode5();
        System.out.println(l.convert("LEETCODEISHIRING", 3).equals("LCIRETOESIIGEDHN"));
    }
}
