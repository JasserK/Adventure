import java.util.ArrayList;

public class Map {

    private Room starterRoom;

    //Muligvis gøres mere simpel og praktisk senere?
    public void initializeRooms() {

        ArrayList<Item> itemsInRoom1 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom1 = new ArrayList<>();
        Room room1 = new Room("Room 1", false, "This is the light description for room 1.", "This is the dark description for room 1.", itemsInRoom1, enemiesInRoom1);

        ArrayList<Item> itemsInRoom2 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom2 = new ArrayList<>();
        Room room2 = new Room("Room 2", true, "This is the light description for room 2.", "This is the dark description for room 2.", itemsInRoom2, enemiesInRoom2);

        ArrayList<Item> itemsInRoom3 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom3 = new ArrayList<>();
        Room room3 = new Room("Room 3", false, "This is the light description for room 3.", "This is the dark description for room 3.", itemsInRoom3, enemiesInRoom3);

        ArrayList<Item> itemsInRoom4 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom4 = new ArrayList<>();
        Room room4 = new Room("Room 4", false, "This is the light description for room 4.", "This is the dark description for room 4.", itemsInRoom4, enemiesInRoom4);

        ArrayList<Item> itemsInRoom5 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom5 = new ArrayList<>();
        Room room5 = new Room("Room 5", false, "This is the light description for room 5.", "This is the dark description for room 5.", itemsInRoom5, enemiesInRoom5);

        ArrayList<Item> itemsInRoom6 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom6 = new ArrayList<>();
        Room room6 = new Room("Room 6", false, "This is the light description for room 6.", "This is the dark description for room 6.", itemsInRoom6, enemiesInRoom6);

        ArrayList<Item> itemsInRoom7 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom7 = new ArrayList<>();
        Room room7 = new Room("Room 7", false, "This is the light description for room 7.", "This is the dark description for room 7.", itemsInRoom7, enemiesInRoom7);

        ArrayList<Item> itemsInRoom8 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom8 = new ArrayList<>();
        Room room8 = new Room("Room 8", false, "This is the light description for room 8.", "This is the dark description for room 8.", itemsInRoom8, enemiesInRoom8);

        ArrayList<Item> itemsInRoom9 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom9 = new ArrayList<>();
        Room room9 = new Room("Room 9", false, "This is the light description for room 9.", "This is the dark description for room 9.", itemsInRoom9, enemiesInRoom9);

        starterRoom = room1;

        Room.setRoomConnections(room1, null, room4, room2, null);
        Room.setRoomConnections(room2, null, null, room3, room1);
        Room.setRoomConnections(room3, null, room6, null, room2);
        Room.setRoomConnections(room4, room1, room7, null, null);
        Room.setRoomConnections(room5, null, room8, null, null);
        Room.setRoomConnections(room6, room3, room9, null, null);
        Room.setRoomConnections(room7, room4, null, room8, null);
        Room.setRoomConnections(room8, room5, null, room9, room7);
        Room.setRoomConnections(room9, room6, null, null, room8);

        //Room 1
        itemsInRoom1.add(new Item("Item1", "Item1 description"));
        itemsInRoom1.add(new Food("Bad1", "Bad food1 description", -100));
        itemsInRoom1.add(new RangedWeapon("Desert Eagle", "You are practicing your second amendment.", 50, 2));
        itemsInRoom1.add(new MeleeWeapon("Sword1", "Sword1 description", 20));



        //Room 2
        itemsInRoom2.add(new Item("Item2", "Item2 description"));
        itemsInRoom2.add(new Food("Food2", "Food2 description", 20));

        //Room 3
        itemsInRoom3.add(new Item("Item3", "Item3 description"));
        itemsInRoom3.add(new Item("Item33", "Item33 description"));

        //Room 4
        itemsInRoom4.add(new Food("Mario mushroom", "What is this doing here?", 100));

        room4.addEnemy(new Enemy("Grim fyr", 100, new MeleeWeapon("Baseball bat", "Wooden baseball bat", 15 )));

        //Room 5
        itemsInRoom5.add(new Item("Item5", "Item5 description"));
        itemsInRoom5.add(new Food("Shawarma", "That was a healthy shawarma!", 50));

        //Room 6
        itemsInRoom6.add(new Item("Item6", "Item6 description"));

        //Room 7
        itemsInRoom7.add(new Food("Crystal meth", "Walter White wouldn't be happy about this..", -50));

        //Room 8
        itemsInRoom8.add(new Item("Item8", "Item8 description"));


        //Room 9
        itemsInRoom9.add(new Food("Dirt", "Yuck!", -20));
    }

    public Room getStarterRoom() {
        return starterRoom;
    }


}
