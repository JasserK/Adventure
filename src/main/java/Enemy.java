public class Enemy {
    private String enemyName;
    private int health;
    private Weapon weapon;


    public Enemy(String enemyName, int health, Weapon weapon) {
        this.enemyName = enemyName;
        this.health = health;
        this.weapon = weapon;
    }
}
