public class Adventure {
    Map map = new Map();
    Player player = new Player();

    public Adventure() {
        map.initializeRooms();
        player.setCurrentRoom(map.getStarterRoom());

    }

    public ReturnMessage playerMoves(String direction) {
        return player.go(direction);
    }

    public String look() {
        return player.look();
    }

    public Room lookDirection(String direction) {
        return player.lookDirection(direction);
    }

    public boolean playerPicksUpItem (String itemName) {
        return player.takeItem(itemName);
    }

    public boolean playerDropsItem (String itemName) {
        return player.dropItem(itemName);
    }

    public StringBuilder printPlayerInventory () {
        return player.printInventory();
    }

    public ReturnMessage playerEatsFood (String itemName) {
        return player.eatItem(itemName);
    }

    public boolean playerIsAlive() {
        return player.isAlive();
    }
    public int playerHealth () {
        return player.getPlayerHealth();
    }


}
