import java.util.Scanner;


public class UserInterface {

    private Adventure adventure = new Adventure();
    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public void startProgram() {

        System.out.println(startMessage());
        System.out.println(adventure.playerEntersRoom());
        while (running) {


            String input = scanner.nextLine().trim().toLowerCase();
            String[] inputSplit = input.split(" ", 2);

            if (inputSplit.length <= 1) { //Håndterer kommandoer med kun ét eller nul ord
                switch (input) {
                    case "look": // Få description af current room
                        System.out.println(adventure.playerLooks());
                        break;

                    case "help":
                        System.out.println(showHelp());
                        break;

                    case "inventory", "i":
                        System.out.println(adventure.playerPrintInventory());
                        break;

                    case "equipped", "e":
                        System.out.println(adventure.playerPrintEquipped());
                        break;

                    case "health":
                        System.out.println("Your current health is: " + adventure.playerHealth());
                        break;

                    case "attack", "a":
                        AttackDTO dto = adventure.playerAttacks();
                        switch (dto.getReturnMessage()) {
                            case OK, ENEMY_IS_DEAD:
                                System.out.println("You have dealt " + dto.getEnemyName() + " " + dto.getDamageDealt() + " damage.");
                                switch (dto.getReturnMessage()) {
                                    case OK:

                                        System.out.println(dto.getEnemyName() + " now has " + dto.getRemaingEnemyHealth() + " HP" + "\n" +
                                                dto.getEnemyName() + " damaged you by " + dto.getDamageTaken());
                                        break;

                                    case ENEMY_IS_DEAD:
                                        System.out.println("You killed " + dto.getEnemyName());
                                        break;
                                }
                                System.out.println("Your remaining HP: " + dto.getRemaingPlayerHealth());
                                break;
                            case CANT:
                                System.out.println("You have no ammo..");
                                break;
                            case ITEM_NOT_FOUND:
                                System.out.println("No weapons equipped");
                                break;
                            case ENEMY_NOT_FOUND:
                                System.out.println("No enemy to attack");
                                break;

                        }
                        break;

                    case "light":
                        ReturnMessage returnMessage = adventure.playerTurnsOnLight();
                        switch (returnMessage) {
                            case OK ->
                                    System.out.println("You are using your trusty matchbox\n" + adventure.playerEntersRoom());
                            case CANT -> System.out.println("Cannot light up a lit room..");
                            case ITEM_NOT_FOUND -> System.out.println("You don't have a matchbox silly");
                        }
                        break;


                    case "exit", "quit":
                        running = false;
                        System.out.println("You have tucked your tail between your legs, and ran away from battle!");
                        break;

                    default:
                        System.out.println(invalidCommandPrompt());
                        break;
                }
            } else {


                switch (inputSplit[0]) { //Håndterer kommandoer med flere ord

                    case "look": // Kig et sted hen
                        Room roomLookedAt = adventure.playerLooksDirection(inputSplit[1]);
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

                    case "equip", "e":
                        String equipInput = inputSplit[1];
                        EquipDTO dto = adventure.playerEquipsWeapon(equipInput);

                        switch (dto.getReturnMessage()) {
                            case OK -> System.out.println("You have equipped " + dto.getItem().getName());
                            case CANT -> System.out.println("You cannot equip " + dto.getItem().getName());
                            case ITEM_NOT_FOUND -> System.out.println(inputSplit[1] + " not found");
                        }
                        break;

                    case "eat":
                        switch (adventure.playerEatsFood(inputSplit[1])) {
                            case OK -> System.out.println("You have eaten " + inputSplit[1]);
                            case CANT -> System.out.println("You cannot eat " + inputSplit[1]);
                            case ITEM_NOT_FOUND -> System.out.println(inputSplit[1] + " not found");
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
                            case OK -> {
                                System.out.println("Going " + direction);
                                System.out.println(adventure.playerEntersRoom());
                            }
                            case CANT -> System.out.println("You cannot go in this direction");
                            case ITEM_NOT_FOUND -> System.out.println("Invalid direction");
                        }

                        break;

                    default:
                        System.out.println(invalidCommandPrompt());

                }
            }

            if (!adventure.playerIsAlive()) {
                System.out.println(Colour.ANSI_RED + "You died\n" + Colour.ANSI_RESET + "Play again? y / n");
                String deadInput;
                while (true) {
                    deadInput = scanner.nextLine();
                    if (deadInput.equalsIgnoreCase("y")) {
                        adventure = new Adventure();
                        System.out.println(startMessage());
                        break;
                    } else if (deadInput.equalsIgnoreCase("n")) {
                        running = false;
                        break;
                    } else System.out.println("Invalid input");
                }
            }

        }
    }


    private StringBuilder startMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to Adventure!\n");
        sb.append("Survive as long as you can until your defeat... )\n");

        return sb;
    }

    private StringBuilder showHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("These are the following commands you can use:\n");
        sb.append(Colour.ANSI_BLUE + "help" + Colour.ANSI_RESET + ": Shows this message\n\n");


        sb.append("Possible directions: " + Colour.ANSI_BLUE + "(n/north) / (s/south) / (e/east) / (w/west) / (b/back)\n" + Colour.ANSI_RESET);
        sb.append(Colour.ANSI_BLUE + "look" + Colour.ANSI_RESET + ":               Get description of the current room\n");
        sb.append(Colour.ANSI_BLUE + "look (direction)" + Colour.ANSI_RESET + ":   Name of the room in said direction\n");
        sb.append(Colour.ANSI_BLUE + "go (direction)" + Colour.ANSI_RESET + ":     Character goes said direction\n");


        sb.append(Colour.ANSI_BLUE + "i / inventory" + Colour.ANSI_RESET + ":      Checks the player's inventory\n");
        sb.append(Colour.ANSI_BLUE + "e / equipped" + Colour.ANSI_RESET + ":       Checks equipped weapon\n");
        sb.append(Colour.ANSI_BLUE + "health" + Colour.ANSI_RESET + ":             Checks the player's health level\n");
        sb.append(Colour.ANSI_BLUE + "take (Item)" + Colour.ANSI_RESET + ":        Takes said item in the room\n");
        sb.append(Colour.ANSI_BLUE + "light" + Colour.ANSI_RESET + ":              Lights up a dark room\n");
        sb.append(Colour.ANSI_BLUE + "drop (Item)" + Colour.ANSI_RESET + ":        Drops said item from player's inventory\n");
        sb.append(Colour.ANSI_BLUE + "e / equip (Weapon)" + Colour.ANSI_RESET + ": Equips weapon from player's inventory\n");
        sb.append(Colour.ANSI_BLUE + "a / attack" + Colour.ANSI_RESET + ":         Attacks\n");
        sb.append(Colour.ANSI_BLUE + "exit / quit" + Colour.ANSI_RESET + ":        Exits program");

        return sb;

    }


    private String invalidCommandPrompt() {
        return Colour.ANSI_RED + "Invalid command\nType " + Colour.ANSI_BLUE + "\"help\" " + Colour.ANSI_RED + "for a list of commands." + Colour.ANSI_RESET;
    }

    private String firstLetterToUpperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Returner uændret hvis strengen er tom eller null
        }
        String[] stringArray = input.split(" ");
        String strings = "";
        for (String string : stringArray) {
            strings += string.substring(0, 1).toUpperCase() + string.substring(1) + " ";
        }
        return strings.trim();

    }

}