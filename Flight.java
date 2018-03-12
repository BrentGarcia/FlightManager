
/**
 *
 * Description: Class that represents a flight between.
 *
 * two airports, using a specific Plane, and departing at a specific Time.
 *
 * @author Brent Garcia
 *
 * @version 1.0
 *
 */
import java.text.NumberFormat;

public class Flight {

    private Plane plane;
    private String number;
    private double cost;
    private Time departure;
    private int duration;
    private Airport source;
    private Airport destination;

    public Flight(Plane p, String n, double c, Time de, int du, Airport src,
            Airport dst) {
        plane = p;
        number = n;
        cost = c;
        departure = de;
        duration = du;
        source = src;
        destination = dst;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getNumber() {
        return number;
    }

    public double getCost() {
        return cost;
    }

    public Airport getDestination() {
        return destination;
    }

    public Time getDeparture() {
        return departure;
    }

    public Time getArrival() {
        int h = departure.getHour();
        int m = departure.getMinute() + duration;
        if (m >= 60) {
            h += (m / 60);
            m = (m % 60);
        }

        Time arrival = new Time(h, m);

        return arrival;
    }

    public Airport getSource() {
        return source;
    }

    public String toOverviewString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        Time newDuration = new Time();
        newDuration.addMinutes(duration);
        return fmt.format(cost) + "\n" + getDeparture().toString() + " - "
                + getArrival().toString() + "       " + newDuration.getHour()
                + "h:" + newDuration.getMinute() + "m\n" + plane.getAirline()
                + "               " + source + "-" + destination;

    }

    public String toDetailedString() {
        return getDeparture().toString() + " - " + getArrival().toString()
                + "\n" + Airport.getAirportCity(source) + "(" + getSource()
                + ")" + " - " + Airport.getAirportCity(destination)
                + "(" + getDestination() + ")" + "\n" + plane.getAirline()
                + " " + number + " * " + plane.getModel();
    }
}
