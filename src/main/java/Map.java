import java.util.ArrayList;

public class Map {

    private Room starterRoom;


    public void initializeRooms() {
        //Room 1
        ArrayList<Item> itemsInRoom1 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom1 = new ArrayList<>();
        Room room1 = new Room("Room 1", false, "This is the light description for room 1.", "This is the dark description for room 1.", itemsInRoom1, enemiesInRoom1);

        itemsInRoom1.add(new Food("Mysterious food", "You have a weird looking food", -100));
        itemsInRoom1.add(new RangedWeapon("Desert Eagle", "You are practicing your second amendment.", 50, 2));
        itemsInRoom1.add(new MeleeWeapon("katana", "Elegant yet deadly", 20));
        room1.addEnemy(new Enemy("Alfons Åberg", 50, new RangedWeapon("AK-47", "Terrorist starterpack weapon", 15, 10)));

        //Room 2
        ArrayList<Item> itemsInRoom2 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom2 = new ArrayList<>();
        Room room2 = new Room("Room 2", true, "This is the light description for room 2.", "This is the dark description for room 2.", itemsInRoom2, enemiesInRoom2);

        itemsInRoom2.add(new MeleeWeapon("Prison shank", "A shank from Prison break", 15));
        itemsInRoom2.add(new Food("Donkey kong's banana", "Looks like a good banana", 20));

        //Room 3
        ArrayList<Item> itemsInRoom3 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom3 = new ArrayList<>();
        Room room3 = new Room("Room 3", false, "This is the light description for room 3.", "This is the dark description for room 3.", itemsInRoom3, enemiesInRoom3);

        itemsInRoom3.add(new Food("Corn", "That's a corny looking corn", 20));
        room3.addEnemy(new Enemy("Mette Mink", 100, new RangedWeapon("Politic", "Political hypocrisy", 10, 4)));


        //Room 4
        ArrayList<Item> itemsInRoom4 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom4 = new ArrayList<>();
        Room room4 = new Room("Room 4", false, "This is the light description for room 4.", "This is the dark description for room 4.", itemsInRoom4, enemiesInRoom4);

        itemsInRoom4.add(new Food("Mario mushroom", "What is this doing here?", 100));
        itemsInRoom4.add(new Item("Matchbox", "Light a fire with these"));
        room4.addEnemy(new Enemy("Grim fyr", 100, new MeleeWeapon("Baseball bat", "Wooden baseball bat", 10)));

        //Room 5
        ArrayList<Item> itemsInRoom5 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom5 = new ArrayList<>();
        Room room5 = new Room("Room 5", true, "This is the light description for room 5.", "This is the dark description for room 5.", itemsInRoom5, enemiesInRoom5);


        itemsInRoom5.add(new Food("Shawarma", "That was a healthy shawarma!", 70));
        room5.addEnemy(new Enemy("Strip club bouncer 1", 100, new MeleeWeapon("security baton", "Looks like police brutality", 20)));
        room5.addEnemy(new Enemy("Strip club bouncer 2", 100, new RangedWeapon("Glock", "A simple weapon for simple situations", 15, 5)));

        //Room 6
        ArrayList<Item> itemsInRoom6 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom6 = new ArrayList<>();
        Room room6 = new Room("Room 6", true, "This is the light description for room 6.", "This is the dark description for room 6.", itemsInRoom6, enemiesInRoom6);

        room6.addEnemy(new Enemy("Sewer rat", 20, new MeleeWeapon("Unhygienic teeth", "nasty", 20), new Food("Cheese", "A Delicious looking cheese", 20)));

        //Room 7
        ArrayList<Item> itemsInRoom7 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom7 = new ArrayList<>();
        Room room7 = new Room("Room 7", false, "This is the light description for room 7.", "This is the dark description for room 7.", itemsInRoom7, enemiesInRoom7);

        itemsInRoom7.add(new Food("Crystal meth", "Walter White wouldn't be happy about this..", -50));

        //Room 8
        ArrayList<Item> itemsInRoom8 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom8 = new ArrayList<>();
        Room room8 = new Room("Room 8", false, "This is the light description for room 8.", "This is the dark description for room 8.", itemsInRoom8, enemiesInRoom8);

        room8.addEnemy(new Enemy("Jigsaw", 80, new MeleeWeapon("Motor Saw", "WANNA PLAY A LIL GAME?", 50), new Food("Cake", "Someone dropped their birthday cake", 30)));

        //Room 9
        ArrayList<Item> itemsInRoom9 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom9 = new ArrayList<>();
        Room room9 = new Room("Room 9", true, "This is the light description for room 9.", "This is the dark description for room 9.", itemsInRoom9, enemiesInRoom9);

        itemsInRoom9.add(new Food("Dirt", "Yuck!", -30));


        //Bestemmer hvilket rum man starter i:
        starterRoom = room1;

        //Forbinder rummene:
        Room.setRoomConnections(room1, null, room4, room2, null);
        Room.setRoomConnections(room2, null, null, room3, room1);
        Room.setRoomConnections(room3, null, room6, null, room2);
        Room.setRoomConnections(room4, room1, room7, null, null);
        Room.setRoomConnections(room5, null, room8, null, null);
        Room.setRoomConnections(room6, room3, room9, null, null);
        Room.setRoomConnections(room7, room4, null, room8, null);
        Room.setRoomConnections(room8, room5, null, room9, room7);
        Room.setRoomConnections(room9, room6, null, null, room8);
    }

    public Room getStarterRoom() {
        return starterRoom;
    }


}
