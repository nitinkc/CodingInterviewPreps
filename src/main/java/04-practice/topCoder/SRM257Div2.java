package topCoder;

/**
 * Created by nitinc on 3/14/2015.
 *     class SubstitutionCode{

 */
public class SRM257Div2 {

    public static void main(String[] arg) {
        System.out.println(getValue("TRADINGFEW", "LGXWEV"));
    }

    public static int getValue(String key, String code) {
        String tempRet = "";
        for (int i = 0; i < code.length(); i++) {
            if (key.indexOf(code.charAt(i)) >= 0) {
                int t = key.indexOf(code.charAt(i)) + 1;
                if (t == 10) {
                    t = 0;
                    tempRet = tempRet + t;
                } else {
                    tempRet = tempRet + t;
                }
            }
        }
        return Integer.valueOf(tempRet);
    }
}
