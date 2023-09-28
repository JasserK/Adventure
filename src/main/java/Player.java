public class Player {

    private Room currentRoom;
    private Room previousRoom = null;

    public void go(String direction) {


        switch (direction) {
            case "n":
            case "north":

                if (currentRoom.getNorth() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getNorth();
                    System.out.println("going north");
                }

                break;

            case "s":
            case "south":

                if (currentRoom.getSouth() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getSouth();
                    System.out.println("going south");
                }

                break;

            case "e":
            case "east":

                if (currentRoom.getEast() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getEast();
                    System.out.println("going east");
                }

                break;

            case "w":
            case "west":

                if (currentRoom.getWest() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getWest();
                    System.out.println("going west");
                }

                break;

            default:
                System.out.println("invalid direction");
        }

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

    public void look() {
        if (currentRoom.isDark()) {
            System.out.println(currentRoom.getDarkDescription());
        } else {
            System.out.println(currentRoom.getLightDescription());
        }
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
