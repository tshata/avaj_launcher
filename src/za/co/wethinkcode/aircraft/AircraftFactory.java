package za.co.wethinkcode.aircraft;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        String str = type.toLowerCase();
        if (str.equals("balloon")) {
            return new Balloon(name, coordinates);
        }
        else if (str.equals("jetplane")) {
            return new JetPlane(name, coordinates);
        }
        else if (str.equals("helicopter")) {
            return new Helicopter(name, coordinates);
        } else {
            return null;
        }
    }
}
