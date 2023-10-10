public class AttackDTO {
    private ReturnMessage returnMessage;
    private String enemyName;
    private int damageDealt;
    private int damageTaken;

    private int remaingPlayerHealth;
    private int remaingEnemyHealth;

    public AttackDTO(ReturnMessage returnMessage, Enemy enemy, Player player) {
        this.returnMessage = returnMessage;
        this.enemyName = enemy.getName();
        this.damageDealt = player.getEquippedDamage();
        this.damageTaken = enemy.weaponDamage();
        this.remaingPlayerHealth = player.getPlayerHealth();
        this.remaingEnemyHealth = enemy.getHealth();
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

    public int getRemaingPlayerHealth() {
        return remaingPlayerHealth;
    }

    public int getRemaingEnemyHealth() {
        return remaingEnemyHealth;
    }
}
