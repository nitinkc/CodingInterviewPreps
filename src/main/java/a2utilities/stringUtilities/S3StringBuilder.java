package a2utilities.stringUtilities;

/**
 * StringBuilder is NON-SYNCHRONIZED thus more efficient
 * StringBuffer is SYNCHRONIZED (THREAD SAFE) means two threads
 * can call the methods of the object simultaneously. Thus comparatively
 * less efficient
 */
public class S3StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("The").append(" ");
        sb.append("Lord").append(" ");
        sb.append("of").append(" ");
        sb.append("the").append(" ");
        sb.append("rings");

        System.out.println(sb.toString());
        System.out.println("The Lord of the rings");
    }
}
