package a2utilities.stringUtilities;

public class S2StringIsImmutable {
    public static void main(String[] args) {
        String str = "Malgudi Days";
//        Object o = new Object();
//        System.out.println(o);

        System.out.println(str + " : "+ str.hashCode());// "address" is just the hashCode() converted to hex string.
        String str2 = str.toUpperCase();//Creates a new String with upper case letters
        System.out.println(str2 + " : "+str2.hashCode());//new address.
        //clearGarbage();
        String str3 = "Malgudi Days";
        System.out.println(str3.hashCode());

        String str4 = "MALGUDI DAYS".intern();
        System.out.println(str4 + " : "+str4.hashCode());//new address.
    }

    private static void clearGarbage() {
        System.gc();//Intention to run Garbage Collector
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
