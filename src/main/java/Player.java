import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private Room previousRoom = null;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int playerHealth = 80;
    private final int MAX_HEALTH = 100;


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


    public ArrayList<Item> getInventory() {
        return inventory;
    }


    public boolean takeItem(String itemName) {
        Item found = currentRoom.removeItem(itemName);
        if (found != null) {
            inventory.add(found);
            return true;
        } else {
            return false;

        }

    }

    public ReturnMessage eatItem(String itemName) {
        Item found = null;

        for (Item i : inventory) {
            if (itemName.trim().equalsIgnoreCase(i.getItemName())) {
                found = i;
            }
        }

        if (found != null) {
            if (found instanceof Food) {
                playerHealth += ((Food) found).getHealth();
                if (playerHealth > MAX_HEALTH)
                    playerHealth = MAX_HEALTH;
                inventory.remove(found);

                return ReturnMessage.OK;

            } else return ReturnMessage.CANT;
        }
        return ReturnMessage.NOT_FOUND;
    }


    public boolean dropItem(String itemName) {
        Item foundItem = null;
        for (Item i : inventory) {
            if (itemName.trim().equalsIgnoreCase(i.getItemName())) {
                foundItem = i;
            }
        }
        if (foundItem != null) {
            currentRoom.addItem(foundItem);
            inventory.remove(foundItem);
            return true;
        }
        return false;
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


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }


}

