package CoolRPG;

import java.util.Scanner;
public class CoolRPG
{
    public static void main(String[] args) throws InterruptedException
    {
        //BOOLEANS ;D
        boolean playing = true;
        boolean choiceOk = false;
        //OBJECTEN AANMAKEN ZODAT ZE NIET STATIC MOETEN ZIJN WAAROM IK WEET HET NIET :D
        Character player = new Character();
        Shop beginnerShop = new Shop(150);
        Library beginnerLibrary = new Library();
        //BEGIN
        for (int i=0; i<100; ++i) System.out.println();
        System.out.println("*-------------------------");
        System.out.println("* WELCOME TO COOLRPG 0.7V ");
        System.out.println("*-------------------------");
        Scanner scanner = new Scanner(System.in);
        while (player.getName()==null)
        {
            System.out.println("* What is your name, young warrior?");
            player.giveName(scanner.nextLine());
            for (int i=0; i<100; ++i) System.out.println();                  // NAAM GEVEN ONDER CHARACTER KLASSE
        }
        System.out.println("* Welcome, "+ player.name+"." + " An epic journey awaits you!");
        System.out.println("* But first, we must figure out what kind of a person you are.");
        while (!choiceOk)                                                    // ZOLANG SPELER STATS NIET GOED VINDT GENEREER STATS TOT HIJ JA ZEGT
        {
            player.giveStats();
            System.out.println("* Is this ok? Y(es)/N(o)");
            if (MenuPrints.yesOrNo(scanner.nextLine())=="yes")
            {
                for (int i=0; i<100; ++i) System.out.println();
                choiceOk = true;
                for (int i=0; i<100; i++) System.out.println();
            }
            else if (MenuPrints.yesOrNo(scanner.nextLine()).equals("no"))
            {
                for (int i=0; i<100; i++) System.out.println();
            }
            else
            {
                for (int i=0; i<100; i++) System.out.println();
                System.out.println("* That's not an answer, stupid.");
            }
        }
        System.out.println("* It is time to venture forth!");
        MenuPrints.initialize(player,beginnerShop,beginnerLibrary);                         // GIVE SHOP ITEMS, GIVE PLAYER MONEY
        Thread.sleep(2000);
        for (int i=0; i<100; ++i) System.out.println();
        // VANAF HIER GEBEURT ALLES VIA MENUPRINTS EN ANDERE
        while (playing)
        {
            System.out.println("* 1. Search for an adventure.");
            System.out.println("* 2. Go to the shop.");
            System.out.println("* 3. Check inventory.");
            System.out.println("* 4. Go to the library.");
            System.out.println("* 5. Rest for the night ( exit )");
            int choice = 0;
            while(choice==0)
            {
               try
               {
                   choice = MenuPrints.startMenu(scanner.nextLine());
               }
               catch (Exception e) {}
            }
            if ( choice == 1111)                                                    // EASTER EGG ;D
            {
                String[] printout = {"Oh fuu-","5","4","3","2","1","BOOOOOOOOOOOOOOOM!!!"};
                for(String word : printout)
                    System.out.println(word);
                    for(int i=0; i<100; ++i) System.out.println();
                    Thread.sleep(1000);
      
                playing = false;
                for(int i=0; i<100; ++i) System.out.println();
            }
            else if (choice==5)                                          // CHARACTER PLAYER LEAVES
            {
                playing = false;
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* Goodbye!");
                Thread.sleep(1000);
                for (int i=0; i<100; ++i) System.out.println();
            }
            else if (choice==4)                                          // LIBRARY
            {
                for (int i=0; i<100; ++i) System.out.println();
                beginnerLibrary.libraryInterface(player,beginnerLibrary.libraryMenu());
            }
            else if (choice==3)                                          // SPELER CHECKT INVENTORY
            {
                for (int i=0; i<100; ++i) System.out.println();
                MenuPrints.printPlayerInventory(player);
                MenuPrints.inventoryConsumeYN(player);
            }
            else if (choice==2)                                     // SPELER GAAT NAAR SHOP
            {
                for (int i=0; i<100; ++i) System.out.println();
                beginnerShop.shopInterface(player,beginnerShop.shopMenu());           // MENUPRINTS.shopMenu returns a number
            }
            else if (choice==1)                                     // BATTLE TIME
            {
                for (int i=0; i<100; ++i) System.out.println();
                if(player.level>=6)
                {
                    playing = Battle.bossBattle(player,new Boss(player));
                    if(playing)
                    {
                        for (int i=0; i<100; ++i) System.out.println();
                        System.out.println("* Game over! You win!");
                        int score = ((player.stats[0] + player.stats[1] + player.stats[2] + player.stats[3] + player.stats[4] + player.stats [5])*10) + player.money;
                        System.out.println("* Score: " + score);
                        Thread.sleep(3000);
                        playing = false;
                    }
                }
                else
                {
                    playing = Battle.battleStarts(player,new Monster(player));                  // GEWONE BATTLES
                }
            }
        }
    }
}
