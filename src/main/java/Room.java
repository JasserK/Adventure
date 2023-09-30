import java.util.ArrayList;

public class Room {

    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String name;
    private String lightDescription;
    private String darkDescription;
    private boolean isDark;
    private ArrayList<Item> itemsInRoom;


    public Room(String name, boolean isDark, String lightDescription, String darkDescription, ArrayList<Item> itemsInRoom) {
        this.name = name;
        this.isDark = isDark;
        this.lightDescription = lightDescription;
        this.darkDescription = darkDescription;
        this.itemsInRoom = itemsInRoom;
    }

    // Metode til at sætte rummenes connections
    public static void setRoomConnections(Room room, Room north, Room south, Room east, Room west) {
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }

    // Metode til at sætte genstande i rummet
    public void setItemsInRoom(ArrayList<Item> items) {
        this.itemsInRoom = items;
    }


    //Getters
    public String getName() {
        return name;
    }

    public String getLightDescription() {
        return lightDescription;
    }

    public String getDarkDescription() {
        return darkDescription;
    }

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

    public boolean isDark() {
        return isDark;
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
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
    @Override
    public String toString() {
        String description = isDark ? darkDescription : lightDescription;  // "?" er ensbetydende med at man laver en if else statement, koden ser bare mindre rodet ud sådan.

        if (!isDark && !itemsInRoom.isEmpty()) { // Hvis det ER lyst og der ER items i rummet:
            description += "\nItems in the room:";
            for (Item item : itemsInRoom) {
                description += "\n- " + item.getItemName();
            }
        }
        else if (!isDark) { // Hvis det ER lyst og der IKKE er items i rummet:
            description += "\nNo items in sight.";
        }
        else { //Hvis det er mørkt, uanset om der ER eller IKKE er nogen items.
            description += "\nIt's too dark to see if there are any items.";
        }
        return description;
    }






    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }


}
