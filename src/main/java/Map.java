import java.util.ArrayList;

public class Map {

    private Room starterRoom;


    public void initializeRooms() {

        //Opretter og indsætter enemies og items i rum
        //Room 1
        ArrayList<Item> itemsInRoom1 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom1 = new ArrayList<>();
        Room room1 = new Room("Foyer", false, "The foyer welcomes you with warm, natural light streaming through large, arched windows. A grand chandelier adorns the ceiling, casting a gentle glow across marble floors and potted plants.", "As darkness descends, the grandeur of the foyer transforms. The tall arches and massive windows shroud inky shadows, making the room feel like an enigmatic, untouched sanctuary. The dormant chandelier hangs silently overhead.", itemsInRoom1, enemiesInRoom1);

        itemsInRoom1.add(new Food("Mysterious food", "A weird looking food", -100));
        itemsInRoom1.add(new RangedWeapon("Desert Eagle", "You are practicing your second amendment.", 50, 2));
        itemsInRoom1.add(new MeleeWeapon("Katana", "Elegant yet deadly", 20));
        room1.addEnemy(new Enemy("Alfons Åberg", 50, new RangedWeapon("AK-47", "Terrorist starterpack weapon", 15, 10)));

        //Room 2
        ArrayList<Item> itemsInRoom2 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom2 = new ArrayList<>();
        Room room2 = new Room("Library", true, "A library, bathed in soft, golden light, features rows of antique bookshelves, each holding a trove of knowledge. The faint scent of old paper and leather-bound books fills the air.", "Without light, the library feels like a realm of forgotten stories. The rows of antique bookshelves remain hidden in darkness. The scent of old paper and leather-bound books becomes more pronounced, and the room exudes an aura of mystery.", itemsInRoom2, enemiesInRoom2);

        itemsInRoom2.add(new MeleeWeapon("Prison shank", "A shank from Prison break", 15));
        itemsInRoom2.add(new Food("Donkey kong's banana", "Looks like a good banana", 20));

        //Room 3
        ArrayList<Item> itemsInRoom3 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom3 = new ArrayList<>();
        Room room3 = new Room("Art Gallery", false, "An art gallery adorned with spotlights showcases a captivating collection of paintings and sculptures. The room feels like a creative sanctuary, illuminated with colors and shapes.", "Even in the absence of light, the art gallery retains its artistic charm. The sculptures and paintings stand as enigmatic monuments, inviting exploration in the obscurity.", itemsInRoom3, enemiesInRoom3);

        itemsInRoom3.add(new Food("Corn", "That's a corny looking corn", 20));
        room3.addEnemy(new Enemy("Mette Mink", 100, new RangedWeapon("Politic", "Political hypocrisy", 10, 4)));


        //Room 4
        ArrayList<Item> itemsInRoom4 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom4 = new ArrayList<>();
        Room room4 = new Room("Game Room", false, "The game room is filled with the sounds of laughter and competition. Bright neon lights frame arcade machines, foosball tables, and board games.", "In the darkness, the game room takes on an enchanting aura. The arcade machines stand like dormant sentinels, and the room exudes a sense of anticipation, awaiting the spark of excitement to return.", itemsInRoom4, enemiesInRoom4);

        itemsInRoom4.add(new Food("Mario mushroom", "What is this doing here?", 100));
        itemsInRoom4.add(new Item("Matchbox", "Light a fire with these"));
        room4.addEnemy(new Enemy("Grim fyr", 100, new MeleeWeapon("Baseball bat", "Wooden baseball bat", 10)));

        //Room 5
        ArrayList<Item> itemsInRoom5 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom5 = new ArrayList<>();
        Room room5 = new Room("Greenhouse", true, "Sunlight filters through the lush greenery of the greenhouse. The room is alive with the fragrance of blooming flowers and the symphony of chirping birds.", "As darkness envelops the room with no light coming through the windows, the greenhouse transforms into an enigmatic jungle, concealing its fragrant blooms. The atmosphere exudes a sense of untamed wonder, accentuated by the symphony of chirping birds and the soft rustling of leaves, creating an otherworldly ambiance.", itemsInRoom5, enemiesInRoom5);


        itemsInRoom5.add(new Food("Shawarma", "That was a healthy shawarma!", 70));
        room5.addEnemy(new Enemy("Strip club bouncer 1", 100, new MeleeWeapon("security baton", "Looks like police brutality", 20)));
        room5.addEnemy(new Enemy("Strip club bouncer 2", 100, new RangedWeapon("Glock", "A simple weapon for simple situations", 15, 5)));

        //Room 6
        ArrayList<Item> itemsInRoom6 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom6 = new ArrayList<>();
        Room room6 = new Room("Basement", true, "The basement is a storage haven, illuminated by fluorescent lights. Shelves are stacked with forgotten memorabilia, creating an atmosphere of nostalgia and intrigue.", "In the absence of light, the basement becomes an enigmatic vault of memories and forgotten treasures. Each item remains a mystery, hidden in the obscure depths of the room.", itemsInRoom6, enemiesInRoom6);

        room6.addEnemy(new Enemy("Sewer rat", 20, new MeleeWeapon("Unhygienic teeth", "nasty", 20), new Food("Cheese", "A Delicious looking cheese", 20)));

        //Room 7
        ArrayList<Item> itemsInRoom7 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom7 = new ArrayList<>();
        Room room7 = new Room("Home Office", false, "A home office is well-illuminated, ideal for productivity. A neat desk, a comfortable chair, and an inspiring view create a space for focus.", "As the lights fade, the home office takes on a different character, hinting at uncharted ideas and creativity within the obscurity. The workspace evokes the sense of unlimited potential in the dark.", itemsInRoom7, enemiesInRoom7);

        itemsInRoom7.add(new Food("Crystal meth", "Walter White wouldn't be happy about this..", -50));

        //Room 8
        ArrayList<Item> itemsInRoom8 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom8 = new ArrayList<>();
        Room room8 = new Room("Attic", false, "The attic is bathed in soft, natural light, with vintage trunks, family heirlooms, and a small collection of forgotten treasures. The room evokes a sense of history.", "In the absence of light, the attic becomes a trove of enigmatic relics, each bearing secrets waiting to be unearthed from the shadows. The vintage trunks and family heirlooms become silent witnesses to history.", itemsInRoom8, enemiesInRoom8);

        room8.addEnemy(new Enemy("Jigsaw", 80, new MeleeWeapon("Motor Saw", "WANNA PLAY A LIL GAME?", 50), new Food("Cake", "Someone dropped their birthday cake", 30)));

        //Room 9
        ArrayList<Item> itemsInRoom9 = new ArrayList<>();
        ArrayList<Enemy> enemiesInRoom9 = new ArrayList<>();
        Room room9 = new Room("Balcony", true, "The balcony offers a panoramic view of the city below. Under the open sky, the room becomes a peaceful retreat where the cool breeze and the stars above create a sense of serenity.\n", "Even in darkness, the balcony remains a vantage point for contemplating the mysteries of the night. The city lights twinkle in the distance, and the room exudes serenity and introspection under the stars.", itemsInRoom9, enemiesInRoom9);

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

    //Getter til at få starterRoom
    public Room getStarterRoom() {
        return starterRoom;
    }


}
