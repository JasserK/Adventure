public class Adventure {
    private Room currentRoom;
    private Room previousRoom = null;

    public Adventure() {
        initializeRooms();
    }

    private void initializeRooms() {

        Room room1 = new Room("Room 1", false,"This is the light description for room 1.", "This is the dark description for room 1.");
        Room room2 = new Room("Room 2", false,"This is the light description for room 2.", "This is the dark description for room 1.");
        Room room3 = new Room("Room 3", false,"This is the light description for room 3.", "This is the dark description for room 1.");
        Room room4 = new Room("Room 4", false,"This is the light description for room 4.", "This is the dark description for room 1.");
        Room room5 = new Room("Room 5", false,"This is the light description for room 5.", "This is the dark description for room 1.");
        Room room6 = new Room("Room 6", false,"This is the light description for room 6.", "This is the dark description for room 1.");
        Room room7 = new Room("Room 7", false,"This is the light description for room 7.", "This is the dark description for room 1.");
        Room room8 = new Room("Room 8", false,"This is the light description for room 8.", "This is the dark description for room 1.");
        Room room9 = new Room("Room 9", false,"This is the light description for room 9.", "This is the dark description for room 1.");

        currentRoom = room1;


        Room.setRoomConnections(room1, null, room4, room2, null);
        Room.setRoomConnections(room2, null, null, room3, room1);
        Room.setRoomConnections(room3, null, room6, null, room2);
        Room.setRoomConnections(room4, room1, room7, null, null);
        Room.setRoomConnections(room5, null, room8, null, null);
        Room.setRoomConnections(room6, room3, room9, null, null);
        Room.setRoomConnections(room7, room4, null, room8, null);
        Room.setRoomConnections(room8, room5, null, room7, room9);
        Room.setRoomConnections(room9, room6, null, room8, null);

//Tilføj eventuelt noget til null og print "u shall not pass"
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
}
