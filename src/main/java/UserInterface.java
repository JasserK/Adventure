import java.util.Scanner;


public class UserInterface {

    private Adventure adventure = new Adventure();
    private Scanner scanner = new Scanner(System.in);


    public void startProgram() {
        boolean running = true;


        printStartMessage();
        while (running) {
            boolean runSwitch2 = false;
            String input = scanner.nextLine().trim().toLowerCase();
            String[] subInput = input.split(" ");


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
                    runSwitch2 = true;
                    break;
            }

            if (runSwitch2) {
                switch (subInput[0]) {

                    case "look": // Kig et sted hen
                        if (subInput.length == 2)
                            System.out.println(adventure.lookDirection(subInput[1]));
                        else
                            invalidCommandPrompt();
                        break;

                    case "take":
                        if (subInput.length == 2)
                            if (adventure.playerPicksUpItem(subInput[1])) {
                                System.out.println(firstLetterToUpperCase(subInput[1]) + " picked up");
                            } else {
                                System.out.println("Item not available");
                            }
                        else
                            invalidCommandPrompt();
                        break;

                    case "drop":
                        if (subInput.length == 2)
                            if (adventure.playerDropsItem(subInput[1])) {
                                System.out.println(firstLetterToUpperCase(subInput[1]) + " dropped");
                            } else {
                                System.out.println("No such item in inventory");
                            }
                        else
                            invalidCommandPrompt();
                        break;

                    case "eat":
                        switch (adventure.playerEatsFood(subInput[1])) {

                            case OK: {
                                System.out.println("You have eaten " + subInput[1]);
                                break;
                            }
                            case CANT: {
                                System.out.println("You cannot eat " + subInput[1]);
                                break;
                            }
                            case NOT_FOUND: {
                                System.out.println(subInput[1] + " not found");
                                break;
                            }
                        }
                        break;

                    case "go":
                        if (subInput.length != 2) {
                            invalidCommandPrompt();
                        } else {
                            String direction = subInput[1];
                            if (direction.length() == 1) {
                                direction = switch (direction) {
                                    case "n" -> "north";
                                    case "s" -> "south";
                                    case "e" -> "east";
                                    case "w" -> "west";

                                    default -> "invalid";
                                };
                            }
                            if (adventure.playerMoves(direction)) {
                                System.out.println("Going " + direction);
                            } else if (direction.equals("invalid")) {
                                System.out.println("Invalid direction");
                            } else {
                                System.out.println("You cannot go in this direction");
                            }
                        }
                        break;

                    default:
                        invalidCommandPrompt();
                }
            }
        }
    }


    public void printStartMessage() {
        System.out.println("Welcome to Adventure!");
        System.out.println("You are about to embark on an epic adventure in the fabled Eternal city Nokron.");
        System.out.println("But we wary young adventurer! Not only are there riches for the taking, but also nasty monsters!");
        System.out.println("Survive as long as you can until your defeat... )");
    }

    public void showHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("These are the following commands you can use:\n");
        sb.append("help: Shows this message\n");
        sb.append("look: Get description of the current room\n");
        sb.append("look back: Name of the room you previously came from\n");
        sb.append("go n/north: Character goes north\n");
        sb.append("go s/south: Character goes south\n");
        sb.append("go e/east: Character goes east\n");
        sb.append("go w/west: Character goes west\n");
        sb.append("inventory: Checks the player's inventory\n");
        sb.append("take (Item): Takes the item in the room\n");
        sb.append("drop (Item): Drops the item from player's inventory\n");
        sb.append("exit: Exits program");
        System.out.println(sb);

    }


    public void invalidCommandPrompt() {
        System.out.println("Invalid command\nType \"help\" for a list of commands.");
    }

    private String firstLetterToUpperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Returner uændret hvis strengen er tom eller null
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}