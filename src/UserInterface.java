import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure adventure = new Adventure();



//    public void startProgram() {
//        // "skriv look"
//        String noget = input.next();
////        adventure.currentRoom(noget);

//    }
    public void intro(){
        System.out.println("Welcome to the adventure game");
        System.out.println("Please type one of the following: Go north, Go South, Go West, Go east");
        System.out.println("You can always use Exit, help and look"); //TODO lav i et menu format
    }
    public void navigate() {
        boolean loop = true;

        while (loop) {
            System.out.print("Enter your command: ");
            String userInput = scanner.nextLine();
            loop = adventure.move(userInput);
        }
    }
    }
