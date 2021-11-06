package manage;

/**
 * @Author Created by nichaurasia
 * @create on Wednesday, December/30/2020 at 8:28 AM
 */

public class Sandbox {

    public static void main(String[] args) {
        System.out.println(changeXY("xxhixx"));
    }

    public static String changeXY(String str) {
        String s = "";

        if(str.length() == 0){
            return "";
        }

        if(str.substring(0,1).equalsIgnoreCase("x")){
            s = s + "y";
        }else{
            s = s + str.substring(0,1);
        }

        return s + str.substring(1,str.length());
    }

}
