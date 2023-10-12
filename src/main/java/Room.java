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
    private ArrayList<Enemy> enemiesInRoom;

    //Metoder til opbyggelse af rum
    // Konstruktør
    public Room(String name, boolean isDark, String lightDescription, String darkDescription, ArrayList<Item> itemsInRoom, ArrayList<Enemy> enemiesInRoom) {
        this.name = name;
        this.isDark = isDark;
        this.lightDescription = lightDescription;
        this.darkDescription = darkDescription;
        this.itemsInRoom = itemsInRoom;
        this.enemiesInRoom = enemiesInRoom;
    }

    // Sætter rummenes connections
    public static void setRoomConnections(Room room, Room north, Room south, Room east, Room west) {
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }

    // Sætter currentRoom for fjenden og tilføjer fjenden til et rum
    public void addEnemy(Enemy enemy) {
        enemy.setCurrentRoom(this); // Sæt rummet for fjenden
        enemiesInRoom.add(enemy);   // Tilføj fjenden til rummet
    }



    // Metoder som bruges under gameplay
    public void removeEnemy(Enemy enemy) {
        enemiesInRoom.remove(enemy);
    }

    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    public Item removeItem(String itemName) {
        Item foundItem = null;
        for (Item i : itemsInRoom) {
            if (itemName.trim().equalsIgnoreCase(i.getName())) {
                foundItem = i;
            }
        }
        if (foundItem != null) {
            itemsInRoom.remove(foundItem);
        }
        return foundItem;
    }

    public String enterRoom() {
        String description = isDark ? darkDescription : lightDescription;  // "?" er ensbetydende med at man laver en if else statement, koden ser bare mindre rodet ud sådan.
        if (!isDark) {
            if (!enemiesInRoom.isEmpty()) {//Hvis der er enemies i rummet
                if (enemiesInRoom.size() == 1)
                    description += "\nYou see 1 enemy in this room.\nYou are approached by " + enemiesInRoom.get(0).getName();
                else
                    description += "\nYou see " + enemiesInRoom.size() + " enemies in this room.\nYou are approached by " + enemiesInRoom.get(0).getName();
            }
        } else description += "\nYou cant see any enemies, but its too dark to be sure";
        return description;
    }


    //ToString
    @Override
    public String toString() {
        String description = "";

        if (isDark) { //Hvis rummet er mørkt
            description += "\nIt's too dark to see any items or enemies.";
        } else {
            if (itemsInRoom.isEmpty()) { // Hvis det er lyst og der IKKE er items i rummet:
                description += "\nNo items to behold...";
            } else { // Hvis det er lyst og der ER items i rummet:
                description += "\nBehold! Items in the room:";
                for (Item item : itemsInRoom) {
                    description += "\n- " + item.getName();
                }
            }
        }
        return description;
    }

    //Getters
    public String getName() {
        return name;
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

    public ArrayList<Enemy> getEnemiesInRoom() {
        return enemiesInRoom;
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

    public void setDark(boolean dark) {
        isDark = dark;
    }

}
