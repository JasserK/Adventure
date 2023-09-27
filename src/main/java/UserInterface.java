import java.util.Scanner;

public class UserInterface {

    private Adventure adventure = new Adventure();
    private Scanner scanner = new Scanner(System.in);

    public void startProgram() {
        boolean running = true;

        printStartMessage();
        while (running) {

            String originalString = scanner.nextLine().trim().toLowerCase();
            String[] substrings = originalString.split(" ");
            switch (substrings[0]) {

                case "look":
                    if (substrings.length == 2)
                        lookBack(substrings[1]);
                    else if (substrings.length == 1)
                        look();
                    else
                        invalidCommandPrompt();
                    break;

                case "help":
                    showHelp();
                    break;
                case "go":
                    go(substrings[1]);
                    break;

                case "exit":
                    running = false;
                    System.out.println("You have tucked your tail between your legs, and ran away from battle!");
                    break;
                default:
                    invalidCommandPrompt();
            }


        }
    }


    public void go(String direction) {


        switch (direction) {
            case "n":
            case "north":

                if (adventure.getCurrentRoom().getNorth() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    adventure.setPreviousRoom(adventure.getCurrentRoom());
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getNorth());
                    System.out.println("going north");
                }

                break;

            case "s":
            case "south":

                if (adventure.getCurrentRoom().getSouth() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    adventure.setPreviousRoom(adventure.getCurrentRoom());
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getSouth());
                    System.out.println("going south");
                }

                break;

            case "e":
            case "east":

                if (adventure.getCurrentRoom().getEast() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    adventure.setPreviousRoom(adventure.getCurrentRoom());
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getEast());
                    System.out.println("going east");
                }

                break;

            case "w":
            case "west":

                if (adventure.getCurrentRoom().getWest() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    adventure.setPreviousRoom(adventure.getCurrentRoom());
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getWest());
                    System.out.println("going west");
                }

                break;

            default:
                System.out.println("invalid direction");
        }

    }

    public void printStartMessage() {
        System.out.println("Welcome to Adventure!");
        System.out.println("You are about to embark on an epic adventure in the fabled Eternal city Nokron.");
        System.out.println("But we wary young adventurer! Not only are there riches for the taking, but also nasty monsters!");
        System.out.println("Survive as long as you can until your defeat... ;)");
    }

    public void showHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("These are the following commands you can use:\n");
        sb.append("help: Show this message\n");
        sb.append("look: Get description of current room\n");
        sb.append("go n/north: Character goes north\n");
        sb.append("go s/south: Character goes south\n");
        sb.append("go e/east: Character goes east\n");
        sb.append("go w/west: Character goes west\n");
        sb.append("exit: Exits program");
        System.out.println(sb);

    }

    public void lookBack(String direction) {
        if (adventure.getPreviousRoom() == null)
            System.out.println("You haven't moved yet.");
        else {
            switch (direction) {
                case "back":
                    System.out.println(adventure.getPreviousRoom().getName());
                    break;
                default:
                    System.out.println("You cannot look that way.");
            }
        }
    }

    public void look() {
        if (adventure.getCurrentRoom().isDark()) {
            System.out.println(adventure.getCurrentRoom().getDarkDescription());
        } else {
            System.out.println(adventure.getCurrentRoom().getLightDescription());
        }
    }

    public void invalidCommandPrompt () {
        System.out.println("Invalid command\nType \"help\" for a list of commands.");
    }

}