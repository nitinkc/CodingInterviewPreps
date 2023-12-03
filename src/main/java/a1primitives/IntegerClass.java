package a1primitives;

public class IntegerClass {
    public static void main(String[] args) {
        //To Wrapper Class
        Integer fromPrimitiveInt = Integer.valueOf(25);//From String or primitive to Wrapper
        Integer fromString = Integer.valueOf("90");
        System.out.println(fromString +"::"+fromPrimitiveInt);

        //To Primitive Ints
        int i = Integer.parseInt("12345");//Parses strings into primitive int; From String to primitive
        int j = Integer.valueOf("1234").intValue();//From String or primitive to Wrapper
        int k =  Integer.valueOf(23).intValue();

        //DON'T USE THIS
        Integer integer = Integer.getInteger("90");
        System.out.println();//Uses system property. BE CAREFUL, returns null
    }
}
