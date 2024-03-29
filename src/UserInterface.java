import items.Item;
import items.weapons.Weapon;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure adventure = new Adventure();
    PlaySound playSound = new PlaySound();

    public void startGame() {
        intro();

        while (true) {

            System.out.print("> ");
            String userInput = scanner.nextLine().toLowerCase();
            String[] splitUserInput = userInput.split(" "); //for extracting take or drop
            String editedCommand = splitUserInput[0].toLowerCase();

            switch (editedCommand) {
                case "exit" -> {
                    exit();
                    return;
                }
                case "north", "n" -> goNorth();
                case "south", "s" -> goSouth();
                case "west", "w" -> goWest();
                case "east", "e" -> goEast();
                case "look" -> look();
                case "help" -> helpMsg();
                case "inventory", "inv" -> inventory();
                case "take", "t" -> takeItem(splitUserInput);
                case "drop", "d" -> dropItem(splitUserInput);
                case "health", "h","hp" -> health();
                case "eat", "drink" -> consume(splitUserInput);
                case "equip", "eq" -> equip(splitUserInput);
                case "attack", "att" -> attack(splitUserInput);
                default -> System.out.println("Invalid command. Try again");
            }
            gameOver();
        }
    }

    // Runs the welcome messages
    public void intro() {
        System.out.println("");
        System.out.println("             _                 _                   _____                      \n" +
                "    /\\      | |               | |                 / ____|                     \n" +
                "   /  \\   __| |_   _____ _ __ | |_ _   _ _ __ ___| |  __  __ _ _ __ ___   ___ \n" +
                "  / /\\ \\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\ | |_ |/ _` | '_ ` _ \\ / _ \\\n" +
                " / ____ \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/ |__| | (_| | | | | | |  __/\n" +
                "/_/    \\_\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|\\_____|\\__,_|_| |_| |_|\\___|\n" +
                "                                                                              ");
        System.out.println("\033[1mWelcome to the adventure game!\033[0m");
        System.out.println("Youre a young adventurer finding yourself in front of an abandoned castle in a far away country from home.\n" +
                " You decide to enter because you want to uncover the mysteries of the castle \n" +
                " and perhaps find valuable loot for your adventures.");
        System.out.println("");
        System.out.println("To start the game, write one of the following: north, south, west, east.");
        System.out.println("Type help to get a list of commands");
        System.out.println("*************************************");

//      Uncomment to play music, beaware ITS LOUD.
//      PlaySoundMethod();
    }

    // println for currentroom that the player is in
    public void currentRoomPrint() {
        Room currentRoom = adventure.getPlayer().getCurrentRoom();
        System.out.printf("You are now in %s. \n%s\n", currentRoom.getName(), currentRoom.getDescription());
    }

    public void exit() {
        System.out.println("Exiting game, thanks for playing...");
    }

    public void look() {
        Room currentRoom = adventure.getPlayer().getCurrentRoom();
        System.out.println("Looking around...");
        System.out.println(currentRoom.getLongDescription());
    }

    // if no room is near, this msg will display so
    public void noRoomMsg() {
        System.out.println("You cannot go there. Try again.");
    }

    public void helpMsg() {
        System.out.println("\033[1mHere's a list of commands\033[0m:\n" +
                "Commands:                              Description of command:\n" +
                "* north/south/east/west or n/s/e/w     - Move to a room in given direction \n" +
                "* look                                 - Look around your current room\n" +
                "* help                                 - Get a list of commands\n" +
                "* inventory/inv                        - See the list of items in your inventory\n" +
                "* take                                 - Take the item\n" +
                "* drop                                 - Drop the item\n" +
                "* equip                                - Equip a weapon to attack a enemy\n" +
                "* health                               - See your current health\n" +
                "* attack                               - If you see a enemy, you can attack them\n" +
                "* eat                                  - Eat a food in your inventory, it might kill you or give you more health..\n" +
                "* drink                                - Drink a liquid in your inventory, it might kill you or give you more health..\n" +
                "* exit                                 - Exit out of the game \n" +
                "\033[1m**********************************************************************************\033[0m");
    }

    public void inventory() {
        List<Item> playerItems = adventure.getInventory();
        if (!playerItems.isEmpty()) {
            System.out.println("You have these items in your bag:");
            for (Item item : playerItems) {
                System.out.println("- " + item.getShortName());
            }
            Weapon currentWeapon = adventure.getPlayersCurrentWeapon();
            if (currentWeapon != null) System.out.println("You are currently equipped with " + currentWeapon);
        } else {
            System.out.println("Your bag is empty.");
        }
    }

    public void health() {
        int health = adventure.health();
        if (health >= 100) {
            System.out.println("Your current health is " + "██████████ " + health);
        } else if (health > 50 && health < 100) {
            System.out.println("Your current health is " + "███████▒▒▒ " + health + ". You still have good health.");
        } else if (health < 50 && health > 20) {
            System.out.println("Your current health is " + "█████▒▒▒▒▒ " + health + ". You should not fight, find something to eat to get more health.");
        } else {
            System.out.println("Your current health is " + "███▒▒▒▒▒▒▒ " + health + ". You are dying, find something to eat, quickly");
        }
    }

    public void takeItem(String[] splitString) {
        try {
            Item takeItem = adventure.takeItem(splitString[1]);
            if (takeItem != null) {
                System.out.println("You picked up " + takeItem.getShortName());
            } else {
                System.out.println("There are no " + splitString[1] + " in the room");
            }
        } catch (ArrayIndexOutOfBoundsException aioob) {
            System.out.println("You need to write what item you want to take eg. take water");
        }
    }

    public void dropItem(String[] splitString) {
        try {
            Item dropItem = adventure.dropItem(splitString[1]);
            if (dropItem != null) {
                System.out.println("You dropped " + dropItem.getShortName());
            } else {
                System.out.println("There are no " + splitString[1] + " in your inventory");
            }
        } catch (ArrayIndexOutOfBoundsException aioob) {
            System.out.println("You need to write what item you want to drop eg. drop bow");
        }
    }

    public void consume(String[] splitString) {
        String consumableName = splitString[1];
        String response = adventure.consume(consumableName);

        switch (response) {
            case "poisonous" -> {
                System.out.println("This doesn’t look healthy, are you sure you want to eat it?");
            }
            case "eaten" -> System.out.println("You ate " + consumableName);
            case "drunken" -> System.out.println("You drank " + consumableName);
            case "not consumable" -> System.out.println("You cannot consume this item, it is neither food nor liquid.");
            case "does not exist" -> System.out.println("This food is neither in your bag nor in the room.");
        }
    }

    public void equip(String[] splitString) {
        try {
            String weaponName = splitString[1];
            String response = adventure.equip(weaponName);

            switch (response) {
                case "does not exist" -> System.out.println("This weapon is not in your inventory");
                case "equipped" -> System.out.println("You have equipped " + weaponName);
                case "not a weapon" -> System.out.println("You cannot equip this item, it's not a weapon.");
            }
        } catch (ArrayIndexOutOfBoundsException aioob) {
            System.out.println("You need to write what weapon you want to equip. eg equip bow");
        }
    }


    public void goNorth() {
        Room northernRoom = adventure.goNorth();
        if (northernRoom != null) {
            System.out.println("Going north...");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    public void goSouth() {
        Room southernRoom = adventure.goSouth();
        if (southernRoom != null) {
            System.out.println("Going south...");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    public void goEast() {
        Room easternRoom = adventure.goEast();
        if (easternRoom != null) {
            System.out.println("Going east...");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    public void goWest() {
        Room westernRoom = adventure.goWest();
        if (westernRoom != null) {
            System.out.println("Going west...");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    public void attack(String[] splitString) {


        String isAttackPossible = adventure.isAttackPossible();
        if (isAttackPossible == null) {
            System.out.println("You are not equipped with a weapon, so you cannot attack.");
        } else if (isAttackPossible.equals("broken")) {
            System.out.println("You cannot attack with this weapon, it's broken.");
        } else {
            System.out.println(isAttackPossible);
            try {
                String enemyName = splitString[1];
                Enemy attackingEnemy = adventure.getPlayer().getCurrentRoom().findEnemy(enemyName);
                attackEnemy(attackingEnemy);
            } catch (ArrayIndexOutOfBoundsException exception) {

                if (!adventure.getPlayer().getCurrentRoom().getEnemiesArrayList().isEmpty()) { //if there are enemies in the room
                    attackEnemy(adventure.getPlayer().getCurrentRoom().getEnemiesArrayList().get(0));//then attack the first one
                } else {
                    System.out.println(adventure.attackAir());//else attack air
                }
            }
        }
    }

    public void attackEnemy(Enemy enemy) {
        String resultOfAttack = adventure.attack(enemy);
        String enemyName = enemy.getEnemyName();
        System.out.println("You attacked " + enemyName + " with " + adventure.getPlayer().getCurrentWeapon().getDamagePoints() + " damage");
        System.out.printf("%s says: How dare you attack me!..\n", enemyName);


        if (resultOfAttack.equals("dead")) {
            System.out.printf(enemyName + " is dead.\n");
            gameOver();
        } else {
            System.out.printf("%s attacked you with %s damage.\n%s has %d health left.\n", enemyName, resultOfAttack, enemyName, enemy.getEnemyHealth());
            System.out.printf("%s says: You will regret doing that!\n", enemyName);
            String resultOfEnemyAttack = adventure.enemyAttacks(enemy, adventure.getPlayer());
            if (resultOfEnemyAttack.equals("dead")) {
                System.out.printf("%s killed you. \n", enemyName);
                gameOver();
                return;
            }
            System.out.println("Both have survived. You have got " + adventure.getPlayer().getHealth() + " health left.");
        }
    }

    public void gameOver() {
        if (adventure.getPlayer().getCurrentRoom().getName().contains("Room 5") && adventure.getPlayer().getCurrentRoom().getEnemiesArrayList().isEmpty()) {
            System.out.println("Game over, you played well..");
            System.out.println("We will sent you back, to the main menu...");

            adventure = new Adventure();
            startGame();
            return;
        } else if (adventure.getPlayer().getHealth() <= 0) {
            System.out.println("__   __                                 _                _ \n" +
                    "\\ \\ / /__  _   _    __ _ _ __ ___    __| | ___  __ _  __| |\n" +
                    " \\ V / _ \\| | | |  / _` | '__/ _ \\  / _` |/ _ \\/ _` |/ _` |\n" +
                    "  | | (_) | |_| | | (_| | | |  __/ | (_| |  __/ (_| | (_| |\n" +
                    "  |_|\\___/ \\__,_|  \\__,_|_|  \\___|  \\__,_|\\___|\\__,_|\\__,_|");

            System.out.println("We will sent you back, to the main menu...");
            System.out.println("*********************************************************");
            adventure = new Adventure();
            startGame();
        }


    }

    public void PlaySoundMethod() {
        String lydfilSti = "introsound.wav";
        PlaySound.afspilLydfil(lydfilSti);
    }
}