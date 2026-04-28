package a2utilities.stringUtilities.stringMethods;

public class M2StrEquals {
    public static void main(String[] args) {

        String movie = new String("Harry Potter");
        String drama = new String("Harry Potter");
        System.out.println(movie == drama); // same content but points to diff objects(reference or address) so returning false
        System.out.println(movie .equals(drama)); // same content and pointing to same object(reference or address) so returning true

        String food = "Indian cuisine";
        String foods = "Indian cuisine";
        // without obj creation both  returns true
        System.out.println(food == foods);
        System.out.println(food.equals(foods));

        System.out.println(movie.equalsIgnoreCase("harry potter"));
    }
}
