import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static String csvFile = "data/movementList.csv";
    private static HashMap<String, Double> orgHashMapSpend = new HashMap<>();
    private static HashMap<String, Double> orgHashMapObtain = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(csvFile));
        parseCsv(lines);
    }

    private static void parseCsv(List<String> csvLines){
        double spending = 0;
        double obtainment = 0;

        for (int i = 1; i < csvLines.size(); i++) {
            String[] fragments = csvLines.get(i).split(",", 8);

            String spendingDecimeter = fragments[7].replace(",", ".")
                    .replaceAll("\"", "").trim();
            spending += Double.parseDouble(spendingDecimeter);
            double moneySpend = Double.parseDouble(spendingDecimeter);

            double moneyObtainment = Double.parseDouble(fragments[6]);
            obtainment += Double.parseDouble(fragments[6]);

            String[] transaction = fragments[5].trim().split("\\s{3,}");
            String[] transact = transaction[1].split("/");
            String[] transactSupply = transact[transact.length - 1].split("\\\\");
            String organization = transactSupply[transactSupply.length - 1].trim();

            if (!orgHashMapSpend.containsKey(organization)) {
                orgHashMapSpend.put(organization, moneySpend);
                orgHashMapObtain.put(organization, moneyObtainment);
            } else {
                double sumSpend = orgHashMapSpend.get(organization);
                sumSpend += moneySpend;
                orgHashMapSpend.put(organization, sumSpend);

                double sumObtain = orgHashMapObtain.get(organization);
                sumObtain += moneyObtainment;
                orgHashMapObtain.put(organization, sumObtain);
            }
        }

        System.out.println("Общий расход: " + spending);
        System.out.println("Общий приход: " + obtainment + "\n");

        System.out.println("Суммы расходов по организациям:");
        for (Map.Entry<String, Double> s : orgHashMapSpend.entrySet()) {
            System.out.printf("%-30s %s %s %n", s.getKey(), s.getValue(), "руб.");
        }

        System.out.println("\n=======================================\n\nСуммы прихода по организациям:");
        for (Map.Entry<String, Double> s : orgHashMapObtain.entrySet()) {
            System.out.printf("%-30s %s %s %n", s.getKey(), s.getValue(), "руб.");
        }
    }
}


