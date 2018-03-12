
/**
 *
 * Description: Smart Enumeration of Airports in system that can change between
 *
 * that can change between air code and city name.
 *
 * @author Brent Garcia
 *
 * @version 1.0
 *
 */
public enum Airport {
    PHX,
    LAX,
    SFO,
    NRT,
    SIN;

    public static String getAirportCity(Airport a1) {
        String port;
        switch (a1) {
            case PHX:
                port = "Phoenix";
                break;
            case LAX:
                port = "Los Angeles";
                break;
            case SFO:
                port = "San Francisco";
                break;
            case NRT:
                port = "Tokyo";
                break;
            default:
                port = "Unknown City";
                break;
        }

        return port;
    }

}
