public class Enemy {
    private String name;
    private int health;
    private Weapon weapon;
    private Food food;
    private final int MIN_HEALTH = 0;

    private Room currentRoom;

    public boolean isAlive() {
        return health > MIN_HEALTH;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Enemy(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public Enemy(String name, int health, Weapon weapon, Food food) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.food = food;
    }

    public int weaponDamage() {
        return weapon.getDamage();
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 1) {
            die();
        }
    }

    private void die() {
        currentRoom.addItem(weapon);
        if (food != null) {
            currentRoom.addItem(food);
        }
        currentRoom.removeEnemy(this);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
