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


    public Room(String name, boolean isDark, String lightDescription, String darkDescription) {
        this.name = name;
        this.isDark = isDark;
        this.lightDescription = lightDescription;
        this.darkDescription = darkDescription;
    }

    public static void setRoomConnections(Room room, Room north, Room south, Room east, Room west) {
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }

    public static void addItemsToRoom(Room room, ArrayList<Item> items ) {

        room.setItemsInRoom(items);
    }


    public String getName() {
        return name;
    }

    public String getLightDescription() {
        return lightDescription;
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

    public String getDarkDescription() {
        return darkDescription;
    }

    public boolean isDark() {
        return isDark;
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

    public void setItemsInRoom(ArrayList<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

//ToString


    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public Item findItem(String itemName) {

        Item result = null;
        for (Item item : itemsInRoom) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                result = item;
                break;
            }
        }
        return result;

    }

    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    public boolean removeItem(Item item) {
        if (itemsInRoom.contains(item)) {
            itemsInRoom.remove(item);
            return true;
        }
        return false;
    }

    //Take metode

    public boolean take(String itemName, Player player, Room currentRoom) {
        boolean canPickUp = false;
        for (int i = 0; i < currentRoom.getItemsInRoom().size(); i++) {
            Item item = currentRoom.getItemsInRoom().get(i);
            if (item.getItemName().equalsIgnoreCase(itemName)) {

                player.getInventory().add(item);

                currentRoom.getItemsInRoom().remove(i);
                canPickUp = true;

                //Der skal være en print for dette i UI samt getInventory metoden skal laves i player klassen.
            }

        }
        return canPickUp;
    }


    // ? er ensbetydende med at man laver en if else statement, koden ser bare mindre rodet ud sådan.
    @Override
    public String toString() {
        String description = isDark ? darkDescription : lightDescription;

        if (itemsInRoom.isEmpty()) {
            return description;
        }
        description = "Items in the room:";
        for (Item item : itemsInRoom) {
            description += "\n- " + item.getItemName();
        }

        return description;
    }

}
