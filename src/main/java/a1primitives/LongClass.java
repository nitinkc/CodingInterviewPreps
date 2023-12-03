package a1primitives;

public class LongClass {
    public static void main(String[] args) {
        Long fromPrimitiveLong = Long.valueOf(123L);
        Long fromString = Long.valueOf("458756541544785");

        System.out.println(fromPrimitiveLong + "::" + fromString);

        long i = Long.parseLong("1123");
        long j = Long.valueOf(458756541544785L).longValue();
    }
}
