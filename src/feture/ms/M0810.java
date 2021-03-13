package feture.ms;

/**
 * @author lanshan
 */
public class M0810 {
    /**
     * image = [
     * [1,1,1],
     * [1,1,0],
     * [1,0,1]
     * ]
     * sr = 1, sc = 1, newColor = 2
     *
     * 输出：[
     * [2,2,2],
     * [2,2,0],
     * [2,0,1]
     * ]

     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || sr < 0 || sc < 0) {
            return image;
        }
        int pre = image[sr][sc];
        if (pre == newColor) {
            return image;
        }
        find(image, sr, sc, pre, newColor);
        return image;
    }

    private void find(int[][] image, int x, int y, int pre, int newColor) {
        if (x < 0 || x > image.length - 1 || y < 0 || y > image[0].length - 1) {
            return;
        }
        if (image[x][y] == pre) {
            image[x][y] = newColor;
            find(image, x - 1, y, pre, newColor);
            find(image, x + 1, y, pre, newColor);
            find(image, x, y - 1, pre, newColor);
            find(image, x, y + 1, pre, newColor);
        }
    }
}
