import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        LocalTime now = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Time now: " + now.format(timeFormatter));

        airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(f -> {
                    LocalTime lt = toDateTime(f.getDate());
                    return f.getType().equals(Flight.Type.DEPARTURE)
                            && lt.isAfter(now) && lt.isBefore(now.plusHours(2));
                }).forEach(System.out::println);
    }

    private static LocalTime toDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalTime();
    }
}

