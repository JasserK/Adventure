public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String name, String description, int damage) {
        super(name, description, damage);
    }

    @Override
    public void useAmmo() {}
    @Override
    public int getDamage() {
        return super.getDamage();
    }

    @Override
    public int getAmmo() {
        return 1; //getAmmo() returnerer er altid 1 for MeleeWeapons. Derfor vil der altid være "ammo" og attack() tillader at der angribes.
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
