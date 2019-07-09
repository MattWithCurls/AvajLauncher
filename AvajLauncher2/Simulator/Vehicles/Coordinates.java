package Simulator.Vehicles;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;

        if (height > 100){
            this.height = 100;
        } 
    }

    public int getLongitude()
    {
        return this.longitude;
    }

    public int getLatitude()
    {
        return this.latitude;
    }

    public int getHeight()
    {
        return this.height;
    }
}