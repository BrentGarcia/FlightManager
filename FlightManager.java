
/**
 * Description: Store instances of the Flight Class & support generating a list
 * of potential itineraries
 *
 * @author Brent Garcia
 * @version 1.0
 */
public class FlightManager {

    //2 instance variables
    private Flight[] flights;
    private int flightCount;

    public FlightManager() {
        flights = new Flight[1];
        flightCount = 0;
    }

    public void addFlight(Flight newFlight) {//add flight to flights array. Uses increaseSize if full
        flightCount++;
        if (flights.length == flightCount) {
            increaseSize();
        }
        flights[flightCount - 1] = newFlight;
    }

    private void increaseSize() {//doubles size of the flights array. keeps contents

        Flight[] temp = new Flight[flights.length * 2];
        for (int i = 0; i < flightCount; i++) {
            temp[i] = flights[i];
        }

        flights = temp;
    }

    public Itinerary[] findItineraries(Airport src,
            Airport dest, Time idealDeparture) {
        Itinerary[] it = new Itinerary[100];
        for (int i = 0; i < flightCount; i++)//start
        {
            if ((flights[i].getSource() == src)//check for 1 flight
                    && (flights[i].getDestination() == dest)
                    && (flights[i].getDeparture().isEarlierThan(idealDeparture))) {
                it[i] = new Itinerary(flights[i]);
            } else if (flights[i].getSource() == src)//search for 2 flight
            {
                for (int x = 0; x < flightCount; x++) {
                    if ((flights[x].getDestination() == dest)
                            && (flights[x].getSource() == flights[i].getDestination())
                            && (flights[i].getDeparture().isEarlierThan(idealDeparture))
                            && (flights[i].getArrival().isEarlierThan(flights[x]
                                    .getDeparture()))) {
                        it[i] = new Itinerary(flights[i], flights[x]);
                    }
                }
            }
        }//close main loop
        return shrinkItineraries(it);

    }

    private Itinerary[] shrinkItineraries(Itinerary[] itineraries) {

        int newSize = 0;
        for (int i = 0; i < itineraries.length; i++) {
            if (itineraries[i] != null) {
                newSize++;
            }
        }

        Itinerary[] copy = new Itinerary[newSize];
        int newIndex = 0;
        for (int i = 0; i < itineraries.length; i++) {
            if (itineraries[i] != null) {
                copy[newIndex] = itineraries[i];
                newIndex++;
            }
        }

        return copy;
    }
}
