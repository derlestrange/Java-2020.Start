import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getSizeFolder();
    }

    private static void getSizeFolder() {

        Logger wrongFormatLogger = LogManager.getLogger("WrongFormatLogger");
        Logger correctFormatLogger = LogManager.getLogger("CorrectFormatLogger");

        final Marker WRONG_FORMAT_LOGGER = MarkerManager.getMarker("WrongFormatPath");
        final Marker CORRECT_FORMAT_LOGGER = MarkerManager.getMarker("CorrectInput");

        Scanner scanner = new Scanner(System.in);
        try {
            for (; ; ) {
                System.out.println("\nEnter folder path: ");
                String userInput = scanner.nextLine();
                File file = new File(userInput);

                if (!file.isDirectory()) {
                    wrongFormatLogger.info(WRONG_FORMAT_LOGGER, "User input: " + userInput);
                    continue;
                }
//                long size = Files.walk(Paths.get(userInput))
//                        .filter(p -> p.toFile().isFile())
//                        .mapToLong(p -> p.toFile().length())
//                        .sum();


                String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
                int unitIndex = (int) (Math.log10(folderSize(new File(userInput))) / 3);
                double unitValue = 1 << (unitIndex * 10);

                String readableSize = new DecimalFormat("#,##0.#")
                        .format(folderSize(new File(userInput)) / unitValue) + " "
                        + units[unitIndex];

                System.out.println("Folder weight: " + readableSize);
                correctFormatLogger.info(CORRECT_FORMAT_LOGGER, "User input: " + userInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static long folderSize(File folder) {
        long length = 0;
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}
