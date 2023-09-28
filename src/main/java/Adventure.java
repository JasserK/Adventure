public class Adventure {
    Map map = new Map();
    Player player = new Player();

    public Adventure() {
        map.initializeRooms();
        player.setCurrentRoom(map.getStarterRoom());

    }

}
