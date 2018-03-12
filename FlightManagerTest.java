
public class FlightManagerTest {

    FlightManager manager;

    public static void main(String[] args) {
        FlightManagerTest fmt = new FlightManagerTest();
        fmt.run();
    }

    public FlightManagerTest() {
        manager = new FlightManager();
        loadFlights();
    }

    public void run() {
        Itinerary[] itineraries = manager.findItineraries(Airport.PHX, Airport.NRT, new Time(8, 0));

        for (Itinerary i : itineraries) {
            System.out.println(i);
        }
    }

    private void loadFlights() {
        manager.addFlight(new Flight(new Plane(Airline.American, "Airbus A321"),
                "495",
                79,
                new Time(11, 5), 100,
                Airport.PHX, Airport.LAX));

        manager.addFlight(new Flight(new Plane(Airline.Delta, "Boeing 717"),
                "1063",
                79,
                new Time(7, 10),
                95,
                Airport.PHX,
                Airport.LAX));

        manager.addFlight(new Flight(new Plane(Airline.American, "Airbus A321"),
                "400",
                44,
                new Time(8, 20),
                127,
                Airport.PHX,
                Airport.SFO));

        manager.addFlight(new Flight(new Plane(Airline.United, "Boeing 787"),
                "400",
                775,
                new Time(10, 50),
                715,
                Airport.LAX,
                Airport.NRT));

        manager.addFlight(new Flight(new Plane(Airline.Delta, "Boeing 787"),
                "400",
                525,
                new Time(10, 50),
                715,
                Airport.SFO,
                Airport.NRT));

        manager.addFlight(new Flight(new Plane(Airline.United, "Boeing 737"),
                "414",
                59,
                new Time(14, 50),
                85,
                Airport.LAX,
                Airport.SFO));
    }
}
