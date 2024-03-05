public class Main {
    public static void main(String[] args) {
        // obj of userinterface
        UserInterface userInterface = new UserInterface();
        // starts intro method
        userInterface.intro();
        //starts the adventure game, in a infiite loop
        while(true){
            userInterface.navigate();
        }

    }
}