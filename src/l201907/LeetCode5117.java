
package l201907;

/**
 * @author lanshan
 */
public class LeetCode5117 {

    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0) {
            return address;
        }
        return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        LeetCode5117 l = new LeetCode5117();
        System.out.println(l.defangIPaddr("1.1.1.1"));
    }
}
