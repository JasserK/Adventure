public class Room {

    Room north;
    Room south;
    Room east;
    Room west;
    String description;


    public Room(Room north, Room south, Room east, Room west, String description) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.description = description;
    }


}
