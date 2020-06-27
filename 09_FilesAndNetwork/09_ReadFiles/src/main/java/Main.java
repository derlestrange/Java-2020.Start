import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter folder path: ");
        Scanner scanner = new Scanner(System.in);
        try {
            for (; ; ) {
                String userInput = scanner.nextLine();
                File file = new File(userInput);

                if(file.isDirectory()){
                    System.out.println("Enter correctly path!");
                    continue;
                }
                long size = Files.walk(Paths.get(userInput))
                        .filter(p -> p.toFile().isFile())
                        .mapToLong(p -> p.toFile().length())
                        .sum();

                String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
                int unitIndex = (int) (Math.log10(size) / 3);
                double unitValue = 1 << (unitIndex * 10);

                String readableSize = new DecimalFormat("#,##0.#")
                        .format(size / unitValue) + " "
                        + units[unitIndex];

                System.out.println("Folder weight: " + readableSize);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
