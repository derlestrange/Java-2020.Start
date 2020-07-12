import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static String csvFile = "data/movementList.csv";

    public static void main(String[] args) throws IOException {
        HashMap<String, Double> org = new HashMap<>();
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

            if (!org.containsKey(organization)) {
                org.put(organization, Double.parseDouble(spendingDecimeter));
            } else {
                double sum = org.get(organization);
                sum += Double.parseDouble(spendingDecimeter);
                org.put(organization, sum);
            }
        }


        System.out.println("Общий расход: " + spending);
        System.out.println("Общий приход: " + obtainment +"\n");
        for (String s : org.keySet()){
            System.out.printf("%-30s %s %s %n", s, org.get(s), "руб.");
        }

    }
}
