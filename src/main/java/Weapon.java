public abstract class Weapon extends Item {
    int damage;
    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public abstract int remainingUses ();



    public void useAmmo () {

    }

    @Override
    public String toString() {
        return super.toString() + "\nDamage: " + damage;
    }
}
