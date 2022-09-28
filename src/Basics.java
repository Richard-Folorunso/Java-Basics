import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class Basics {
    public static void main(String[] args) {
        IntConsumer lambda = (number) -> {
            number += 1;
            System.out.println(number);
        };
        lambda.accept(1);

        Set<String> integerSet = new HashSet<>();
        integerSet.add("Test 1");
        integerSet.add("Test 2");
        integerSet.add("Test 3");
        AtomicInteger key = new AtomicInteger();
        Map<Integer, String> stringMap = integerSet.stream().collect(Collectors.toMap(x -> key.getAndIncrement(), x -> x));
        System.out.println(stringMap);

        try {
            FileWriter fileWriter = new FileWriter("newFile.txt");
            fileWriter.write("Test Data");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        Date date = new Date ();
        date.setTime(1000000000000L + 1000000000000L); // Tue May 17 23:33:20 EDT 2033
        System.out.println(date);
    }
}
