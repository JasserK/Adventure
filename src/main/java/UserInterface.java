import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    public void startProgram() {

    }


    public void go(String direction) {
        String choice = scanner.nextLine();
        switch (choice) {
            case "n" :
            case "north" :
                System.out.println("going north");
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
}
