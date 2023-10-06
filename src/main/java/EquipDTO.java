//TODO delete
public class EquipDTO {
    private ReturnMessage message;
    private Item item;

    public EquipDTO(ReturnMessage message, Item item) {
        this.message = message;
        this.item = item;
    }

    public ReturnMessage getMessage() {
        return message;
    }

    public Item getItem() {
        return item;
    }
}
