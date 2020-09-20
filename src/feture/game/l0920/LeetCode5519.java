package feture.game.l0920;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode5519 {

    public String reorderSpaces(String text) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int blockCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                sb.append(text.charAt(i));
            } else {
                if (sb.length() != 0) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
                blockCount++;
            }
        }
        if (sb.length() != 0) {
            res.add(sb.toString());
        }
        if (res.size() == 1 && blockCount == 0)
            return res.get(0);
        int interval = res.size() - 1;
        if (interval == 0) {
            sb = new StringBuilder(text.length());
            sb.append(res.get(0));
            for (int i = 0; i < blockCount; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int num = blockCount / interval;
        int out = blockCount % interval;
        sb = new StringBuilder(text.length());
        for (int i = 0, resSize = res.size(); i < resSize; i++) {
            String re = res.get(i);
            sb.append(re);
            int temp = num;
            if (i == resSize - 1)
                temp = out;
            for (int j = 0; j < temp; j++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode5519 l = new LeetCode5519();
        System.out.println(l.reorderSpaces("  walks  udp package   into  bar a"));
    }
}
