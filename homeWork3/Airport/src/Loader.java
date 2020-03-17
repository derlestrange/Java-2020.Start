
import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.List;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        System.out.println(airport.getAllAircrafts());

        List<Aircraft> countAircraft = airport.getAllAircrafts();
        System.out.println(countAircraft.size());




    }
}
