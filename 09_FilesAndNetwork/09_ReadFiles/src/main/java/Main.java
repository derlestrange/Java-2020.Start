import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter folder path: ");
        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            Path path = Paths.get(s);
            long size = Files.walk(path)
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
        }
    }
}
