public class Adventure {
    private Room currentRoom;

    public Adventure() {
        initializeRooms();
    }

    private void initializeRooms() {

        Room room1 = new Room("Room 1", "This is the description for room 1.");
        Room room2 = new Room("Room 2", "This is the description for room 2.");
        Room room3 = new Room("Room 3", "This is the description for room 3.");
        Room room4 = new Room("Room 4", "This is the description for room 4.");
        Room room5 = new Room("Room 5", "This is the description for room 5.");
        Room room6 = new Room("Room 6", "This is the description for room 6.");
        Room room7 = new Room("Room 7", "This is the description for room 7.");
        Room room8 = new Room("Room 8", "This is the description for room 8.");
        Room room9 = new Room("Room 9", "This is the description for room 9.");

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

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
