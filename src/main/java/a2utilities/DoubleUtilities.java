package a2utilities;

public class DoubleUtilities {
    public static void main(String[] args) {
        minMaxDouble();

        getDouble();
    }

    private static void getDouble() {
        //Parses the String to primitive double
        double primitiveDoubleFromString = Double.parseDouble("12345.4321");
        System.out.println(primitiveDoubleFromString);

        //Returns Wrapper Double
        Double wrapperDouble = Double.valueOf(primitiveDoubleFromString);
        Double wrapperDoubleFromString = Double.valueOf("12345.4321");

        System.out.println(wrapperDouble + "::"+wrapperDoubleFromString);
    }

    private static void minMaxDouble() {
        //Declare the min value to a primitive
        double min = Double.MIN_VALUE;
        double max = Double.MIN_VALUE;
        System.out.println(min+1);
    }
}
