public class Adventure {
    Map map = new Map();
    Player player = new Player();

    public Adventure() {
        map.initializeRooms();
        player.setCurrentRoom(map.getStarterRoom());

    }

    public boolean playerMoves(String direction) {
        return player.go(direction);
    }

    public String look() {
        return player.look();
    }

    public String lookDirection(String direction) {
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
}
