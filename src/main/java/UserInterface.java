import java.util.Scanner;


public class UserInterface {

    Adventure adventure = new Adventure();
    private Scanner scanner = new Scanner(System.in);
    boolean running = true;

    public void startProgram() {
        while (running) {
            adventure = new Adventure();
            System.out.println(startMessage());
            while (running && adventure.playerHealth() > adventure.playerMinHealth()) {


                String input = scanner.nextLine().trim().toLowerCase();
                String[] inputSplit = input.split(" ", 2);

                if (inputSplit.length <= 1) { //Håndterer kommandoer med kun ét eller nul ord
                    switch (input) {
                        case "look": // Få description af current room
                            System.out.println(adventure.look());
                            break;

                        case "help":
                            showHelp();
                            break;

                        case "inventory":
                            System.out.println(adventure.printPlayerInventory());
                            break;

                        case "health":
                            System.out.println("Your current health is: " + adventure.playerHealth());
                            break;

                        case "exit":
                            running = false;
                            System.out.println("You have tucked your tail between your legs, and ran away from battle!");
                            break;

                        default:
                            invalidCommandPrompt();
                            break;
                    }
                } else {


                    switch (inputSplit[0]) { //Håndterer kommandoer med flere ord

                        case "look": // Kig et sted hen
                            Room roomLookedAt = adventure.lookDirection(inputSplit[1]);
                            if (roomLookedAt == null) {
                                System.out.println("You dont see anything in this direction");
                            } else {
                                System.out.println("You see a door to " + roomLookedAt.getName() + " in this direction");
                            }
                            break;

                        case "take":
                            if (adventure.playerPicksUpItem(inputSplit[1])) {
                                System.out.println(firstLetterToUpperCase(inputSplit[1]) + " picked up");
                            } else {
                                System.out.println("Item not available");
                            }
                            break;

                        case "drop":
                            if (adventure.playerDropsItem(inputSplit[1])) {
                                System.out.println(firstLetterToUpperCase(inputSplit[1]) + " dropped");
                            } else {
                                System.out.println("No such item in inventory");
                            }

                            break;

                        case "eat":
                            switch (adventure.playerEatsFood(inputSplit[1])) {
                                case OK -> System.out.println("You have eaten " + inputSplit[1]);
                                case CANT -> System.out.println("You cannot eat " + inputSplit[1]);
                                case NOT_FOUND -> System.out.println(inputSplit[1] + " not found");
                            }
                            break;

                        case "go":
                            String direction = inputSplit[1];

                            if (direction.length() == 1) {
                                direction = switch (direction) {
                                    case "b" -> "back";
                                    case "n" -> "north";
                                    case "s" -> "south";
                                    case "e" -> "east";
                                    case "w" -> "west";

                                    default -> "invalid";
                                };
                            }
                            switch (adventure.playerMoves(direction)) {
                                case OK -> System.out.println("Going " + direction);
                                case CANT -> System.out.println("You cannot go in this direction");
                                case NOT_FOUND -> System.out.println("Invalid direction");
                            }

                            break;

                        default:
                            invalidCommandPrompt();

                    }
                }
            }
            if (adventure.playerHealth() < adventure.playerMinHealth()) {
                System.out.println("You died...\nPlay again?\ny or n");
                String playAgain = scanner.nextLine();

                boolean yOrN = true;
                do {
                    switch (playAgain) {
                        case "y":
                            break;
                        case "n":
                            running = false;
                            break;
                        default:
                            System.out.println("invalid input");
                            yOrN = false;
                    }
                }while (!yOrN);
            }
        }
    }


    public StringBuilder startMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to Adventure!\n");
        sb.append("You are about to embark on an epic adventure in the fabled Eternal city Nokron.\n");
        sb.append("But be wary, young adventurer! Not only are there riches for the taking, but also nasty monsters!\n");
        sb.append("Survive as long as you can until your defeat... )\n");

        return sb;
    }

    public void showHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("These are the following commands you can use:\n");
        sb.append(Colour.ANSI_BLUE + "help" + Colour.ANSI_RESET + ": Shows this message\n\n");


        sb.append("Possible directions: " + Colour.ANSI_BLUE + "(n/north) / (s/south) / (e/east) / (w/west) / (b/back)\n" + Colour.ANSI_RESET);
        sb.append(Colour.ANSI_BLUE + "look" + Colour.ANSI_RESET + ": Get description of the current room\n");
        sb.append(Colour.ANSI_BLUE + "look (direction)" + Colour.ANSI_RESET + ": Name of the room in said direction\n");
        sb.append(Colour.ANSI_BLUE + "go (direction)" + Colour.ANSI_RESET + ": Character goes said direction\n");

        sb.append(Colour.ANSI_BLUE + "inventory" + Colour.ANSI_RESET + ": Checks the player's inventory\n");
        sb.append(Colour.ANSI_BLUE + "health" + Colour.ANSI_RESET + ": Checks the player's health level\n");
        sb.append(Colour.ANSI_BLUE + "take (Item)" + Colour.ANSI_RESET + ": Takes said item in the room\n");
        sb.append(Colour.ANSI_BLUE + "drop (Item)" + Colour.ANSI_RESET + ": Drops said item from player's inventory\n");
        sb.append(Colour.ANSI_BLUE + "exit" + Colour.ANSI_RESET + ": Exits program");
        System.out.println(sb);

    }


    public void invalidCommandPrompt() {
        System.out.println(Colour.ANSI_RED + "Invalid command\nType " + Colour.ANSI_BLUE + "\"help\" " + Colour.ANSI_RED + "for a list of commands." + Colour.ANSI_RESET);
    }

    private String firstLetterToUpperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Returner uændret hvis strengen er tom eller null
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}