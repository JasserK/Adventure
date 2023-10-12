public class Adventure {
    private Map map = new Map();
    private Player player = new Player();

    public Adventure() {
        map.initializeRooms();
        player.setCurrentRoom(map.getStarterRoom());

    }

    public ReturnMessage playerMoves(String direction) {
        return player.go(direction);
    }

    public String playerLooks() {
        return player.look();
    }

    public String playerEntersRoom() {
        return player.enterRoom();
    }
    public Room playerLooksDirection(String direction) {
        return player.lookDirection(direction);
    }

    public boolean playerPicksUpItem(String itemName) {
        return player.takeItem(itemName);
    }

    public boolean playerDropsItem(String itemName) {
        return player.dropItem(itemName);
    }

    public EquipDTO playerEquipsWeapon(String weaponName) {
        return player.equip(weaponName);
    }

    public StringBuilder playerPrintInventory() {
        return player.printInventory();
    }

public StringBuilder playerPrintEquipped() {
        return player.printEquipped();
    }

    public ReturnMessage playerTurnsOnLight() {
        return player.turnOnLight();
    }

    public ReturnMessage playerEatsFood(String itemName) {
        return player.eatItem(itemName);
    }

    public AttackDTO playerAttacks() {
        return player.attack();
    }

    public boolean playerIsAlive() {
        return player.isAlive();
    }

    public int playerHealth() {
        return player.getPlayerHealth();
    }



}
