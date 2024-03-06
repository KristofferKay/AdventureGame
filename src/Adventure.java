
public class Adventure {
    private Map map = new Map();
    Player player = new Player();



    public Room goNorth(){
        return player.goNorth();
    }

    public Room goSouth(){
        return player.goSouth();
    }

    public Room goWest(){
        return player.goWest();
    }

    public Room goEast(){
        return player.goEast();
    }


}