import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamAPI {
    public static void main(String args[]){
        // Корректное использование потоков для инициализации таблицы частот
        Map<String, Long> freq;

        String file= "streamData.txt";
        Scanner scanner = new Scanner(file);
        //Stream<String> words;
        while(scanner.hasNext()) {
            try (Stream<String> words = Stream.of(scanner.next())) {
                freq = words
                        .collect(groupingBy(String::toLowerCase, counting()));
            }
        }
    }
}
