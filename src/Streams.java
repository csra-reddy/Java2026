import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        //frequency of words using Java 8
        String[] words =  {"a", "b", "a", "b", "c", "a", "d", "c"};

        Map<String, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(x->x, Collectors.counting()));
        System.out.println(map);
    }
}
