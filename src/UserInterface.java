import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);
    Adventure adventure = new Adventure();



    public void startProgram() {
        // "skriv look"
        String noget = input.next();
        adventure.currentRoom(noget);

    }

    public void navigate() {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


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
