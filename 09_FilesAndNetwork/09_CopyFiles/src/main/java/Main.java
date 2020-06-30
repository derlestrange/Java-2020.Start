//import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.*;
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

//                FileUtils.copyDirectory(fileFrom, fileTo);
                copyFolder(fileFrom, fileTo);
                correctFormatLogger.info(CORRECT_FORMAT_LOGGER,
                        "Folder copying from: " + userInputFrom + " to: " + userInputTo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyFolder(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String files[] = sourceLocation.list();

            for (String file : files) {
                File srcFile = new File(sourceLocation, file);
                File destFile = new File(targetLocation, file);
                copyFolder(srcFile, destFile);
            }
        } else {
            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }
    }
}
