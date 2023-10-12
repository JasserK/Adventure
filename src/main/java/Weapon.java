public abstract class Weapon extends Item {
    private int damage;
    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public abstract int getAmmo();


    public abstract void useAmmo();

    @Override
    public String toString() {
        return super.toString() + "\nDamage: " + damage;
    }
}
