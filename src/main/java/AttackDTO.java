public class AttackDTO {
    private ReturnMessage returnMessage;
    private String enemyName;
    private int damageDealt;
    private int damageTaken;
    private int remainingAmmo;

    public AttackDTO(ReturnMessage returnMessage, Enemy enemy, Player player) {
        this.returnMessage = returnMessage;
        this.enemyName = enemy.getName();
        this.damageDealt = player.getEquippedDamage();
        this.damageTaken = enemy.weaponDamage();
        this.remainingAmmo = player.getEquipped().remainingUses();
    }

    public AttackDTO(ReturnMessage returnMessage) {
        this.returnMessage = returnMessage;
    }

    public ReturnMessage getReturnMessage() {
        return returnMessage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public int getRemainingAmmo() {
        return remainingAmmo;
    }
}
