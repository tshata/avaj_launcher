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
            height = 0;
        else if(height > 100)
            height = 100;
        return height;
    }

    public int getLongitude() {
        if(longitude < 0)
            longitude = 0;
        else
            return longitude;
        return 0;
    }

    public int getLatitude() {
        if(latitude < 0)
            latitude = 0;
        return latitude;
    }
}
