import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        copyingFolder();
    }

    private static void copyingFolder() {

        Logger wrongFormatLogger = LogManager.getLogger("WrongFormatLogger");
        Logger correctFormatLogger = LogManager.getLogger("CorrectFormatLogger");

        final Marker WRONG_FORMAT_LOGGER = MarkerManager.getMarker("WrongFormatPath");
        final Marker CORRECT_FORMAT_LOGGER = MarkerManager.getMarker("CorrectInput");

        Scanner scanner = new Scanner(System.in);

        try {
            for (; ; ) {
                System.out.println("\nEnter folder to be moved path: ");
                String userInputFrom = scanner.nextLine();
                File fileFrom = new File(userInputFrom);

                if (!fileFrom.isDirectory()) {
                    wrongFormatLogger.info(WRONG_FORMAT_LOGGER, "User input: " + userInputFrom);
                    continue;
                }

                System.out.println("\nEnter folder folder where you want to move: ");
                String userInputTo = scanner.nextLine();
                File fileTo = new File(userInputTo);

                if (!fileTo.isDirectory()) {
                    wrongFormatLogger.info(WRONG_FORMAT_LOGGER, "User input: " + userInputTo);
                    continue;
                }

                FileUtils.copyDirectoryToDirectory(fileFrom, fileTo);
                correctFormatLogger.info(CORRECT_FORMAT_LOGGER,
                        "Folder copying from: " + userInputFrom + " to: " + userInputTo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
