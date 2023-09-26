import java.util.Scanner;

public class UserInterface {

    private Adventure adventure = new Adventure();
    private Scanner scanner = new Scanner(System.in);

    public void startProgram() {

    }


    public void go(String direction) {


        switch (direction) {
            case "n":
            case "north":

                if (adventure.getCurrentRoom().getNorth() == null) {
                    System.out.println("You cannot go in this direction");
                } else {
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getNorth());
                    System.out.println("going north");
                }

                break;
            case "s" :
            case "south" :
                System.out.println("going south");
                break;
            case "e" :
            case "east" :
                System.out.println("going east");
                break;
            case "w" :
            case "west" :
                System.out.println("going west");
                break;

            default:
                System.out.println("invalid input");


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


        //Den skal finpudses til at give brugeren evt mulighed for hjælp til adskillige ting?
    }
}
