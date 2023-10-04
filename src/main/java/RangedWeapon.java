public class RangedWeapon extends Weapon {
    int ammo;
    public RangedWeapon(String name, String description, int damage, int ammo) {
        super(name, description, damage);
        this.ammo = ammo;
    }


    @Override
    public String toString() {
        return super.toString() + "\nAmmo: " + ammo;
    }
}
