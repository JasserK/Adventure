public class Room {

    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String name;
    private String description;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public static void setRoomConnections(Room room, Room north, Room south, Room east, Room west) {
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Getters
    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    //Setters
    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }
//ToString

}