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
                        System.out.println(adventure.player.lookBack(substrings[1]));

                    else if (substrings.length == 1)
                        adventure.player.look();
                    else
                        invalidCommandPrompt();
                    break;

                case "help":
                    showHelp();
                    break;
                case "go": // ret crash når der kun tastes "go" exception
                    adventure.player.go(substrings[1]);
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



    public void invalidCommandPrompt () {
        System.out.println("Invalid command\nType \"help\" for a list of commands.");
    }

}