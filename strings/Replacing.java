// strings/Replacing.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class Replacing {
    public static String knights =
            "Then, when you have found the shrubbery, " +
                    "you must cut down the mightiest tree in the " +
                    "forest...with... a herring!";

    public static void main(String[] args) {
        System.out.println(
                knights.replaceFirst("f\\w+", "located"));
        System.out.println(
                knights.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
/* Output:
Then, when you have located the shrubbery, you must cut
down the mightiest tree in the forest...with... a
herring!
Then, when you have found the banana, you must cut down
the mightiest banana in the forest...with... a banana!
*/
