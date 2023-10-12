//TODO delete
public class EquipDTO {
    private ReturnMessage returnMessage;
    private Item item;
    private Weapon weapon;


    //Constructors
    public EquipDTO(ReturnMessage returnMessage, Item object) {
        this.returnMessage = returnMessage;
        this.item = object;
    }
    public EquipDTO(ReturnMessage returnMessage, Weapon weapon) {
        this.returnMessage = returnMessage;
        this.weapon = weapon;
    }

    //Getters
    public ReturnMessage getReturnMessage() {
        return returnMessage;
    }
    public Item getItem() {
        return item;
    }
    public Weapon getWeapon() {
        return weapon;
    }
}
