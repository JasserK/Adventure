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


    public String lookDirection(String direction) {
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

        return currentRoom.toString();
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

    public boolean takeItem(String itemName) {
        boolean canTakeItem = false;
        for (Item i : currentRoom.getItemsInRoom()) {
            if (itemName.trim().equalsIgnoreCase(i.getItemName())) {
                inventory.add(i);
                currentRoom.removeItem(i);
                canTakeItem = true;
                break;
            }
        }
        return canTakeItem;
    }

    public boolean dropItem(String itemName) {
        boolean canDropItem = false;
        for (Item i : inventory) {
            if (itemName.trim().equalsIgnoreCase(i.getItemName())) {
                currentRoom.addItem(i);
                inventory.remove(i);
                canDropItem = true;
                break;
            }
        }
        return canDropItem;
    }

    public StringBuilder printInventory() {
        StringBuilder print = new StringBuilder("Inventory:");

        if (inventory.isEmpty()) {
            print.append("\nEmpty");
        } else {
            for (Item i : inventory) {
                print.append("\n").append(i.toString());
            }
        }
        return print;
    }

}

