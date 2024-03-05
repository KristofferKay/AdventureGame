import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);
    Adventure adventure = new Adventure();



    public void startProgram() {
        // "skriv look"
        String noget = input.next();
//        adventure.currentRoom(noget);

    }
    public void intro(){
        System.out.println("Welcome to the adventure game");
        System.out.println("Please type one of the following: Go north, Go South, Go West, Go east");
        System.out.println("You can always use Exit, help and look"); //TODO lav i et menu format
    }
    public void navigate() {

        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();



        switch(input){
            case "go north":
                System.out.println("Go north");
                adventure.move(input);
                break;
            case "go south":
                System.out.println("Go south");
                adventure.move(input);
                break;
            case "go west":
                System.out.println("Go west");
                adventure.move(input);
                break;
            case "go east":
                System.out.println("Go east");
                adventure.move(input);
                break;
            case "look":
                System.out.println(adventure.currentRoom.getName() + " " + adventure.currentRoom.getDescription());
                break;
            default:
                System.out.println("error");
        }



    }
}