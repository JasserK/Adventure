public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String name, String description, int damage) {
        super(name, description, damage);
    }

    @Override
    public int remainingUses() {
        return 1;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
