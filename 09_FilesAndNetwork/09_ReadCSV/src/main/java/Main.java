import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static String csvFile = "data/movementList.csv";

    public static void main(String[] args) throws IOException {
        HashMap<String, Double> organizationsAndExpenses = new HashMap<>();
        List<String> staff = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(csvFile));
        double spending = 0;
        double obtainment = 0;

        for (int i = 1; i < lines.size(); i++) {
            String[] fragments = lines.get(i).split(",", 8);

            String str = fragments[7].replaceAll(",", ".")
                    .replaceAll("\"", "").trim();
            spending += Double.parseDouble(str);

            obtainment += Double.parseDouble(fragments[6]);

            String[] transaction = fragments[5].trim().split("\\s{3,}");
            String[] transact = transaction[1].split("/");
            String[] transactSupply = transact[transact.length - 1].split("\\\\");
            String organization = transactSupply[transactSupply.length - 1];

            staff.add(organization);
        }


        System.out.println("Общий расход: " + spending);
        System.out.println("Общий приход: " + obtainment);
        staff.forEach(System.out::println);

    }
}
