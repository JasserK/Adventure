public class Weapon extends Item {
    int damage;
    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDamage: " + damage;
    }
}
