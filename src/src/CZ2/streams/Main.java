package src.CZ2.streams;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // IO Stream
        // Stream - kropla po kropli
        // BufferedReader - kilka kropli jednocześnie
        // Stream - w nazwie to streamy bajtowe np.
        // InputStream / OutputStream - bajty
        // Reader / Writer - znaki

        System.out.println("Charset.default: " + Charset.defaultCharset());

        String someSentence = "some sentence óęłśą";
        byte[] bytes = someSentence.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        String result = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(result);
        System.out.println();

        Charset.availableCharsets().keySet().forEach(System.out::println);

        Charset utf8 = StandardCharsets.UTF_8;
        Charset windows_1250 = Charset.forName("windows-1250");

        char c = 2764;
        System.out.println(c);

    }
}
