import java.util.Scanner;

public class UserInterface {

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
