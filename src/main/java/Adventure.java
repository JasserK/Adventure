public class Adventure {
    Map map = new Map();
    Player player = new Player();

    public Adventure() {
        map.initializeRooms();
        player.setCurrentRoom(map.getStarterRoom());

    }

    public boolean go(String direction) {
        return player.go(direction);
    }

}
