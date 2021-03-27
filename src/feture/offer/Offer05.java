package feture.offer;

/**
 * @author lanshan
 */
public class Offer05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0)
            return s;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}
