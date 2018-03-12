
/**
 *
 * Description: Class of Itinerary
 *
 * @author Brent Garcia
 *
 * @version 1.0
 *
 */
import java.text.NumberFormat;

public class Itinerary {

    // 2 Instance methods (flights)
    private Flight f1;
    private Flight f2;

    public Itinerary(Flight x) {//overloaded constructor with 1 flight & null
        f1 = x;
        f2 = null;
    }

    public Itinerary(Flight x, Flight y) {//overloaded constructor with 2 flights
        f1 = x;
        f2 = y;
    }

    public Flight getFirstFlight() {
        return f1;
    }

    public Flight getSecondFlight() {
        return f2;
    }

    public boolean hasConnection() {
        if ((getFirstFlight() != null) && (getSecondFlight() != null)) {
            return true;
        } else {
            return false;
        }
    }

    public double getTotalCost() {
        if ((getFirstFlight() != null) && (getSecondFlight() != null)) {
            return f1.getCost() + f2.getCost();
        } else {
            return f1.getCost();
        }
    }

    public Time getDeparture() {
        return f1.getDeparture();
    }

    public Time getArrival() {
        return f2.getArrival();
    }

    @Override
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        if ((getFirstFlight() != null) && (getSecondFlight() != null)) {
            return "Total Cost: " + fmt.format(getTotalCost()) + "\n"
                    + f1.toDetailedString() + "\n" + f2.toDetailedString();
        } else {
            return "Total Cost: " + fmt.format(getTotalCost()) + "\n"
                    + f1.toDetailedString();
        }
    }
}
