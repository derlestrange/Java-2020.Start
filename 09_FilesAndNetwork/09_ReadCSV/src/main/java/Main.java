import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static String csvFile = "data/movementList.csv";
    private static HashMap<String, Double> orgHashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(csvFile));
        parseCsv(lines);
    }

    private static void parseCsv(List<String> csvLines){
        double spending = 0;
        double obtainment = 0;

        for (int i = 1; i < csvLines.size(); i++) {
            String[] fragments = csvLines.get(i).split(",", 8);

            String spendingDecimeter = fragments[7].replaceAll(",", ".")
                    .replaceAll("\"", "").trim();
            spending += Double.parseDouble(spendingDecimeter);
            double spend = Double.parseDouble(spendingDecimeter);

            obtainment += Double.parseDouble(fragments[6]);

            String[] transaction = fragments[5].trim().split("\\s{3,}");
            String[] transact = transaction[1].split("/");
            String[] transactSupply = transact[transact.length - 1].split("\\\\");
            String organization = transactSupply[transactSupply.length - 1].trim();

            if (!orgHashMap.containsKey(organization)) {
                orgHashMap.put(organization, spend);
            } else {
                double sum = orgHashMap.get(organization);
                sum += spend;
                orgHashMap.put(organization, sum);
            }
        }

        System.out.println("Общий расход: " + spending);
        System.out.println("Общий приход: " + obtainment + "\n");
        System.out.println("Суммы расходов по организациям:");
        for (String s : orgHashMap.keySet()) {
            System.out.printf("%-30s %s %s %n", s, orgHashMap.get(s), "руб.");
        }
    }
}


