import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);
    Adventure adventure = new Adventure();



    public void startProgram() {
        // "skriv look"
        String noget = input.next();
//        adventure.currentRoom(noget);

    }

    public void navigate() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the adventure game");
        System.out.println("Please type one of the following: Go north, Go South, Go West, Go east");
        System.out.println("You can always use Exit, help and look"); //TODO lav i et menu format
        String input = scanner.nextLine();

        if (input.equals("look")) {
            System.out.println("Looking around..");
        }

        switch(input){
            case "go north":
                System.out.println("Go north");
                break;
            case "go south":
                System.out.println("Go south");
                break;
            case "go west":
                System.out.println("Go west");
                break;
            case "go east":
                System.out.println("Go east");
                break;
        }



    }
}