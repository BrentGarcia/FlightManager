
/**
 *
 * Description: Class that represents plane in the system.
 *
 * @author Brent Garcia
 *
 * @version 1.0
 *
 */
public class Plane {

    private Airline airline;
    private String model;

    public Plane(Airline initAirline, String initModel) {
        airline = initAirline;
        model = initModel;
    }

    public Airline getAirline() {
        return airline;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return airline + " * " + model;
    }
}
