public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String name, String description, int damage) {
        super(name, description, damage);
    }

    @Override
    public int remainingUses() {
        return 1; //remainingUses() returnerer er altid 1 for MeleeWeapons. Hvis det var 0, så ville attack() betragte det som at våbnet ikke har flere skud.
    }

    @Override
    public void useAmmo() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
