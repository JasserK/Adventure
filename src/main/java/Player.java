import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private Room previousRoom = null;
    private ArrayList<Item> inventory = new ArrayList<>();

    public boolean go(String direction) {

        boolean canGo = false;

        switch (direction) {
            case "n":
            case "north":

                if (currentRoom.getNorth() != null) {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getNorth();
                    canGo = true;
                }

                break;

            case "s":
            case "south":


                if (currentRoom.getSouth() != null) {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getSouth();
                    canGo = true;
                }

                break;

            case "e":
            case "east":


                if (currentRoom.getEast() != null) {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getEast();
                    canGo = true;
                }

                break;

            case "w":
            case "west":


                if (currentRoom.getWest() != null) {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getWest();
                    canGo = true;
                }

                break;

            default:
                break;
        }
        return canGo;
    }


    public String lookBack(String direction) {
        String message;
        if (previousRoom == null)
            message = "You haven't moved yet.";
        else {
            switch (direction) {
                case "back":
                    message = previousRoom.getName();
                    break;
                default:
                    message = "You cannot look that way.";
            }
        }
        return message;
    }

    public String look() {
        String message;
        if (currentRoom.isDark()) {
            message = currentRoom.getDarkDescription();

        } else {
            message = currentRoom.getLightDescription();

        }
        return message;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }



    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean takeItem(Item item, Room currentRoom) {
        if (currentRoom.removeItem(item)) {
            inventory.add(item);
            return true;
        } else {
            return false;
        }
    }

}

