import java.util.Random;
import java.util.Scanner;

public class Tutorial {
    public static void main(String[] args) {
        //System
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Enemy
        String[] enemies =  { "Zombie", "Skeleton Warrior", "Bat", "Vampire" };
        int maxEnemyHealth = 90;
        int enemyAttackDamage = 30;

        //Player
        int playerHealth = 100;
        int playerAttackDamage = 20;
        int numHealtPotions = 3;
        int healtPotionHealAmount = 25;
        int healthPotionDropChance = 50; // percentage

        boolean running = true;

        System.out.println("Welcome to the dungeon!");

        GAME:
        while(running){
            System.out.println("-------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);

            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("You have encountered a " + enemy + "!");


            while(enemyHealth > 0){
                System.out.println("\t Your HP is: " + playerHealth);
                System.out.println("\t The enemy's HP is: " + enemyHealth);
                System.out.println("\t \n What would you like to do?");
                System.out.println("\t 1. Attack");
                System.out.println("\t 2. Drink a health potion");
                System.out.println("\t 3. Run away");

                String input = in.nextLine();

                switch(input) {
                    case "1":
                        int damage = rand.nextInt(playerAttackDamage);
                        enemyHealth -= damage;
                        System.out.println("\t You did " + damage + " damage!");
                        break;
                    case "2":
                        if (numHealtPotions > 0) {
                            playerHealth += healtPotionHealAmount;
                            numHealtPotions--;
                            System.out.println("\t You drank a health potion!");
                        } else {
                            System.out.println("\t You have no health potions!");
                        }
                    case "3":
                        System.out.println("\t You ran away!");
                        break GAME;
                }
            }
        }

    }
}
