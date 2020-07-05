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
        double spending = 0;
        double obtainment = 0;
        for (String line : lines) {
            String[] fragments = line.split(",", 8);

            String str = fragments[7].replaceAll(",", ".")
                    .replaceAll("\"", "")
                    .replaceAll("[А-я]", "0");
            spending+=Double.parseDouble(str);

            obtainment+=Double.parseDouble(fragments[6].replaceAll("[A-я]", "0"));
            staff.add(str);
        }

        System.out.println("Общий расход: " + spending);
        System.out.println("Общий приход: " + obtainment);

        //staff.forEach(System.out::println);
    }
}
