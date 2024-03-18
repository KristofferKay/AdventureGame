import items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String name;
    private String longDescription;
    private String shortDescription;
    private Room north;
    private Room east;
    private Room west;
    private Room south;
    private Enemies enemies;
    private ArrayList<Item> roomItems = new ArrayList<>();
    private ArrayList<Enemies> enemiesArrayList = new ArrayList<>();

    private boolean beenThere = false;

    public Room(String name, String longDescription, String shortDescription) {
        this.name = name;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
    }

    public String getDescription(){
        if(beenThere){
            return getShortDescription();
        }else{
            return getLongDescription();
        }
    }

    public void addItem(Item ... items){
        roomItems.addAll(Arrays.asList(items)); //adds all the items to inventory
    }

    public void addEnemies(Enemies ... enemies){
        enemiesArrayList.addAll(Arrays.asList(enemies));
    }

    public Item findItemInRoom(String shortName) {
        for (Item item : roomItems) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public Item removeItemInRoom(String shortName){
        Item item = findItemInRoom(shortName);
        roomItems.remove(item);
        return item;    }

    public ArrayList<Item> getAllItems(){
        return roomItems;
    }

    public String getName() {
        return name;
    }

    public Enemies getEnemies() {
        return enemies;
    }

    public Enemies setEnemies(){
        return enemies;
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
        String description = longDescription;
        if(!roomItems.isEmpty()){
            description += "\nItems in the room: \n";
            for(Item item : roomItems){
                description += item.getShortName() + ". ";
                description += item.getLongName() + "\n";
            }
        }
        return description;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        String description = shortDescription;
        if(!roomItems.isEmpty()){
            description += "\nItems in the room: \n";
            for(Item item : roomItems){
                description += item.getShortName() + "\n";
            }
        }
        return description;
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
