import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private Room previousRoom = null;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int playerHealth = 80;
    private final int MAX_HEALTH = 100;
    private final int MIN_HEALTH = 0;
    private Weapon equipped;



    public ReturnMessage go(String direction) {
        ReturnMessage result = ReturnMessage.OK;
        switch (direction) {
            case "b", "back":
                if (previousRoom == null) {
                    result = ReturnMessage.CANT;
                } else {
                    Room tempCurrentRoom = currentRoom;
                    currentRoom = previousRoom;
                    previousRoom = tempCurrentRoom;
                }
                break;

            case "n", "north":

                if (currentRoom.getNorth() == null || currentRoom.isDark()) {
                    result = ReturnMessage.CANT;
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getNorth();
                }
                break;

            case "s", "south":

                if (currentRoom.getSouth() == null || currentRoom.isDark()) {
                    result = ReturnMessage.CANT;
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getSouth();
                }
                break;

            case "e", "east":

                if (currentRoom.getEast() == null || currentRoom.isDark()) {
                    result = ReturnMessage.CANT;
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getEast();
                }
                break;

            case "w", "west":

                if (currentRoom.getWest() == null || currentRoom.isDark()) {
                    result = ReturnMessage.CANT;
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getWest();
                }
                break;

            default:
                result = ReturnMessage.ITEM_NOT_FOUND;
                break;
        }
        return result;
    }


    public Room lookDirection(String direction) {
        Room lookingAt = null;
        if (!currentRoom.isDark()) {
            switch (direction) {
                case "b", "back":
                    lookingAt = previousRoom;
                    break;

                case "n", "north":
                    lookingAt = currentRoom.getNorth();
                    break;

                case "s", "south":
                    lookingAt = currentRoom.getSouth();
                    break;

                case "e", "east":
                    lookingAt = currentRoom.getEast();
                    break;

                case "w", "west":
                    lookingAt = currentRoom.getWest();
                    break;

                default:
            }
        }

        return lookingAt;
    }

    public String look() {
        return currentRoom.toString();
    }

    public String enterRoom() {
        return currentRoom.enterRoom();
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
            if (itemName.trim().equalsIgnoreCase(i.getName())) {
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
        return ReturnMessage.ITEM_NOT_FOUND;
    }


    public boolean dropItem(String itemName) {
        Item foundItem = null;
        for (Item i : inventory) {
            if (itemName.trim().equalsIgnoreCase(i.getName())) {
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
   // Gammel equip metode
   // public ReturnMessage equip(String itemName) {
   //     Item found = null;
   //
   //     for (Item i : inventory) {
   //         if (itemName.trim().equalsIgnoreCase(i.getItemName())) {
   //             found = i;
   //         }
   //     }
   //     if (found != null) {
   //         if (found instanceof Weapon) {
   //             if (equipped != null) {
   //                 inventory.add(equipped);
   //             }
   //             equipped = (Weapon) found;
   //             inventory.remove(found);
   //             return ReturnMessage.OK;
   //
   //         } else return ReturnMessage.CANT;
   //     }
   //     return ReturnMessage.NOT_FOUND;
   // }



    public EnumAndObjectDTO equip(String itemName) {

        EnumAndObjectDTO equipDTO;
        Item found = null;
        for (Item i : inventory) {
            if (itemName.trim().equalsIgnoreCase(i.getName())) {
                found = i;
            }
        }
        if (found != null) {
            if (found instanceof Weapon) {
                if (equipped != null) {
                    inventory.add(equipped);
                }
                equipped = (Weapon) found;
                inventory.remove(found);
                equipDTO = new EnumAndObjectDTO (ReturnMessage.OK,found);
                return equipDTO;

            } else{
                equipDTO = new EnumAndObjectDTO (ReturnMessage.CANT,found);
                return equipDTO;
            }
        }
        equipDTO = new EnumAndObjectDTO (ReturnMessage.ITEM_NOT_FOUND,found);
        return equipDTO;
    }



    public ReturnMessage attack() {
        if (equipped != null) { //Hvis player har et våben equipped
            if (equipped.remainingUses() > 0) { //Hvis equipped har mere ammo

                ArrayList<Enemy> enemiesInRoom = currentRoom.getEnemiesInRoom();

                if (!enemiesInRoom.isEmpty()) { //Hvis der er enemies i currentRoom
                    Enemy currentEnemy = enemiesInRoom.get(0); //Sætter currentEnemy til første enemy i rummets "enemyliste"
                    currentEnemy.takeDamage(equipped.damage); //currentEnemy mister liv tilsvarende equipped våbens damage

                    if (currentEnemy.isAlive()) {//Hvis enemy stadig er i live...
                        takeDamage(currentEnemy.attack());//...angriber den spilleren tilbage
                    } else {//Hvis enemy er død...
                        currentRoom.removeEnemy(currentEnemy);//... fjernes currentEnemy fra rummet
                    }

                    equipped.useAmmo(); //equipped våben mister en ammo
                    return ReturnMessage.OK;
                } else {
                    return ReturnMessage.ENEMY_NOT_FOUND; //Hvis der IKKE er enemies i currentRoom
                }
            } else {
                return ReturnMessage.CANT; //Hvis equipped IKKE har mere ammo
            }
        }
        return ReturnMessage.ITEM_NOT_FOUND; //Hvis player IKKE har et våben equipped
    }

    public int takeDamage (int damage) {
        playerHealth -= damage;
        return damage;
    }


    public boolean isAlive() {
        return playerHealth > MIN_HEALTH;
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

    public StringBuilder printEquipped() {
        StringBuilder print = new StringBuilder("Equipped:");

        if (equipped == null) {
            print.append("\nEmpty");
        } else {
            print.append("\n").append(equipped.toString());
        }
        return print;
    }


    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setCurrentRoom(Room currentRoom) {//Bruges når ny adventure startes og currentRoom til starterRoom
        this.currentRoom = currentRoom;
    }

}

