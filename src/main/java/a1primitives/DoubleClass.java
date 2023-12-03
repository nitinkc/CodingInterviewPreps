package a1primitives;

public class DoubleClass {
    public static void main(String[] args) {
        //To Wrapper Class
        Double fromPrimitiveInt = Double.valueOf(12.36);//From String or primitive to Wrapper
        Double fromString = Double.valueOf("90.25");
        System.out.println(fromString +"::"+fromPrimitiveInt);

        //To Primitive Ints
        double i = Double.parseDouble("12345");//Parses strings into primitive int; From String to primitive
        double j = Double.valueOf("1234").doubleValue();//From String or primitive to Wrapper
        double k = Double.valueOf(23);

        //DON'T USE THIS
        Integer integer = Integer.getInteger("90");
        System.out.println();//Uses system property. BE CAREFUL, returns null
    }
}
