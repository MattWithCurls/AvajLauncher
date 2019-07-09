package Simulator.Vehicles;

public class Aircraft
{

    protected long id;
    protected String type;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0L;

    protected Aircraft(String type,String name, Coordinates coordinates) {
        this.type = type;
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }

    private long nextId()
    {
        return idCounter++;
    }
}