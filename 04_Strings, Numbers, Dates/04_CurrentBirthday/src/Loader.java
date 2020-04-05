import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Loader {
    public static void main(String[] args) {

        LocalDate birthday = LocalDate.of(1998, Month.JANUARY, 18);
        LocalDate relevantBirthday = birthday;

        Period period = Period.between(birthday, LocalDate.now());

        System.out.println(0 + " " + birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE")));

        for (int i = 0; i < period.getYears(); i++) {

            relevantBirthday = relevantBirthday.plusYears(1);
            System.out.println(i + 1 + " " + relevantBirthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE")));
        }

        System.out.println("Сейчас мне вот столько годиков: " + period.getYears());
    }
}
