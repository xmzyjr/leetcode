
package l201907;

/**
 * @author lanshan
 */
public class LeetCode1108 {

    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0) {
            return address;
        }
        return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        LeetCode1108 l = new LeetCode1108();
        System.out.println(l.defangIPaddr("1.1.1.1"));
    }
}
