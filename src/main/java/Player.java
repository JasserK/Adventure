public class Player {

    private Room currentRoom;
    private Room previousRoom = null;

    public String go(String direction) {
        String message;


        switch (direction) {
            case "n":
            case "north":

                if (currentRoom.getNorth() == null) {
                    message = "You cannot go in this direction";
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getNorth();
                    message = "going north";
                }

                break;

            case "s":
            case "south":

                if (currentRoom.getSouth() == null) {
                    message = "You cannot go in this direction";
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getSouth();
                    message = "going south";
                }

                break;

            case "e":
            case "east":

                if (currentRoom.getEast() == null) {
                    message = "You cannot go in this direction";
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getEast();
                    message = "going east";
                }

                break;

            case "w":
            case "west":

                if (currentRoom.getWest() == null) {
                    message = "You cannot go in this direction";
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getWest();
                    message = "going west";
                }

                break;

            default:
                message = "invalid direction";
        }
        return message;
    }


    public String lookBack(String direction) {
        String message;
        if (previousRoom == null)
            message = "You haven't moved yet.";
        else {
            switch (direction) {
                case "back":
                    message = previousRoom.getName();
                    break;
                default:
                    message = "You cannot look that way.";
            }
        }
        return message;
    }

    public String look() {
        String message;
        if (currentRoom.isDark()) {
            message = currentRoom.getDarkDescription();

        } else {
            message = currentRoom.getLightDescription();

        }
        return message;
    }





    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }
}
