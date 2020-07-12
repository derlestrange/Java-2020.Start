import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

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

            String spendingDecimeter = fragments[7].replaceAll(",", ".")
                    .replaceAll("\"", "").trim();
            spending += Double.parseDouble(spendingDecimeter);

            obtainment += Double.parseDouble(fragments[6]);

            String[] transaction = fragments[5].trim().split("\\s{3,}");
            String[] transact = transaction[1].split("/");
            String[] transactSupply = transact[transact.length - 1].split("\\\\");
            String organization = transactSupply[transactSupply.length - 1].trim();


            organizationsAndExpenses.put(organization, Double.parseDouble(spendingDecimeter));
        }


        System.out.println("Общий расход: " + spending);
        System.out.println("Общий приход: " + obtainment +"\n");
        //staff.forEach(System.out::println);
        for (String s : organizationsAndExpenses.keySet()){
            System.out.printf("%-30s %s %s %n", s, organizationsAndExpenses.get(s), "руб.");
            //System.out.println("Организация: " + s + "\t" + organizationsAndExpenses.get(s) + " руб.");
        }

    }
}
