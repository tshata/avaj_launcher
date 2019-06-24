package za.co.wethinkcode.aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude,int  latitude,int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }
    public int getHeight() {
        if(height < 0)
            System.exit(1);
        else if(height > 100)
            System.exit(1);
        return height;
    }

    public int getLongitude() {
        if(longitude < 0)
            System.exit(1);
        else
            return longitude;
    }

    public int getLatitude() {
        if(latitude < 0)
            System.exit(1);
        return latitude;
    }
}
