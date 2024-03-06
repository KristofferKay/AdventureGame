
public class Adventure {
    private Map map;
    Player player = new Player();


// adventure
    public Adventure() {
        map = new Map();
        currentRoom = map.getRoom1();
    }


    public Room goNorth(){
        return player.goNorth();
    }


}