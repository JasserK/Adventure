import java.util.ArrayList;

public class Map {

    private Room starterRoom;

    //Muligvis gøres mere simpel og praktisk senere?
    public void initializeRooms() {
        ArrayList<Item> itemsInRoom1 = new ArrayList<>();
        itemsInRoom1.add(new Item("Item1", "Item1 description"));
        itemsInRoom1.add(new Item("Item11", "Item11 description"));
        Room room1 = new Room("Room 1", false,"This is the light description for room 1.", "This is the dark description for room 1.", itemsInRoom1);

        ArrayList<Item> itemsInRoom2 = new ArrayList<>();
        itemsInRoom2.add(new Item("Item2", "Item2 description"));
        Room room2 = new Room("Room 2", true,"This is the light description for room 2.", "This is the dark description for room 2.", itemsInRoom2);

        ArrayList<Item> itemsInRoom3 = new ArrayList<>();
        itemsInRoom3.add(new Item("Item3", "Item3 description"));
        itemsInRoom3.add(new Item("Item33", "Item33 description"));
        Room room3 = new Room("Room 3", false,"This is the light description for room 3.", "This is the dark description for room 3.", itemsInRoom3);

        ArrayList<Item> itemsInRoom4 = new ArrayList<>();
        //itemsInRoom4.add(new Item("Item4", "Item4 description"));
        Room room4 = new Room("Room 4", false,"This is the light description for room 4.", "This is the dark description for room 4.", itemsInRoom4);

        ArrayList<Item> itemsInRoom5 = new ArrayList<>();
        itemsInRoom5.add(new Item("Item5", "Item5 description"));
        Room room5 = new Room("Room 5", false,"This is the light description for room 5.", "This is the dark description for room 5.", itemsInRoom5);

        ArrayList<Item> itemsInRoom6 = new ArrayList<>();
        itemsInRoom6.add(new Item("Item6", "Item6 description"));
        Room room6 = new Room("Room 6", false,"This is the light description for room 6.", "This is the dark description for room 6.", itemsInRoom6);

        ArrayList<Item> itemsInRoom7 = new ArrayList<>();
        itemsInRoom7.add(new Item("Item7", "Item7 description"));
        Room room7 = new Room("Room 7", false,"This is the light description for room 7.", "This is the dark description for room 7.", itemsInRoom7);

        ArrayList<Item> itemsInRoom8 = new ArrayList<>();
        itemsInRoom8.add(new Item("Item8", "Item8 description"));
        Room room8 = new Room("Room 8", false,"This is the light description for room 8.", "This is the dark description for room 8.", itemsInRoom8);

        ArrayList<Item> itemsInRoom9 = new ArrayList<>();
        itemsInRoom9.add(new Item("Item9", "Item9 description"));
        Room room9 = new Room("Room 9", false,"This is the light description for room 9.", "This is the dark description for room 9.", itemsInRoom9);

        starterRoom = room1;

        Room.setRoomConnections(room1, null, room4, room2, null);
        Room.setRoomConnections(room2, null, null, room3, room1);
        Room.setRoomConnections(room3, null, room6, null, room2);
        Room.setRoomConnections(room4, room1, room7, null, null);
        Room.setRoomConnections(room5, null, room8, null, null);
        Room.setRoomConnections(room6, room3, room9, null, null);
        Room.setRoomConnections(room7, room4, null, room8, null);
        Room.setRoomConnections(room8, room5, null, room7, room9);
        Room.setRoomConnections(room9, room6, null, room8, null);



    }
    public Room getStarterRoom() {
        return starterRoom;
    }







}
