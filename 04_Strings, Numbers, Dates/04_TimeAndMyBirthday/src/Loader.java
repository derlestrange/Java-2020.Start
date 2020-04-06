import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Loader {
    public static void main(String[] args) {

        LocalDate birthday = LocalDate.of(1998, Month.JANUARY, 18);
        LocalDate relevantBirthday = birthday;
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthday, LocalDate.now());

        for (int i = 0; relevantBirthday.isBefore(now); i++) {
            System.out.println(i + " " + relevantBirthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE")));
            relevantBirthday = relevantBirthday.plusYears(1);
        }

        System.out.println("Сейчас мне вот столько годиков: " + period.getYears());
    }
}
