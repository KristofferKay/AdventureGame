public class Room {
    private String name;
    private String longDescription;
    private String shortDescription;
    private Room north;
    private Room east;
    private Room west;
    private Room south;
    private boolean beenThere = false;

    public Room(String name, String longDescription, String shortDescription) {
        this.name = name;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
    }

    public String getDescription(){
        if(beenThere){
            return shortDescription;
        }else{
            return longDescription;
        }
    }
    public String getName() {
        return name;
    }

    public boolean hasBeenThere() {
        return beenThere;
    }

    public void setBeenThere(boolean beenThere) {
        this.beenThere = beenThere;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
        east.setWest(this);
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
        south.setNorth(this);
    }
}
