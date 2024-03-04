import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);
    Adventure adventure = new Adventure();



    public void startProgram() {
        // "skriv look"
        String noget = input.next();
        adventure.currentRoom(noget);

    }
}
