import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String csvFile = "data/movementList.csv";

    public static void main(String[] args) throws IOException {
        List<String> staff = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(csvFile));
        for (String line : lines) {
            String[] fragments = line.split(",", 6);
            staff.add(fragments[3]);
        }

        staff.forEach(System.out::println);
    }
}
