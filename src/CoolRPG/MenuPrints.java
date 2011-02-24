/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CoolRPG;

/**
 *
 * @author UGent
 */
import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
public class MenuPrints
{
    protected static int startMenu(String input)
    {
        int output = 0;
        input = input.trim();
            if (input.equals("1")||input.equals("1.")||input.equals("one")) { output = 1; }
            else if (input.equals("2")||input.equals("2.")||input.equals("two")) { output = 2; }
            else if (input.equals("3")||input.equals("3.")||input.equals("three")) { output = 3; }         // GEEF LETTER TERUG VAN OPTIE, alles behalve 1234 IS EEN FAAL
            else if (input.equals("4")||input.equals("4.")||input.equals("four")) {  output = 4; }
            else if (input.equals("5")||input.equals("5.")||input.equals("five")) { output = 5; }
            else if (input.equals("c4")) { output = 1111; }
            else if (input.equals("penis")) { System.out.println("* I'm sure you'd love one"); output=0; }
            else if (input.equals("theo")) { System.out.println("* Oh god, please stop violating my game smelly Cypriotic man."); output=0; }
            else if (input.equals("joep")) { System.out.println("* Black hole man! Dundundundundundun DUN DUN."); output=0; }
            else if (input.equals("dieter")) { System.out.println("* One day, I want to be like you master :D"); output=0; }
            else { System.out.println("* That's not a valid option!"); output=0; }
            return output;
        }
    protected static String yesOrNo(String input)
    {
        input = input.toLowerCase();
        input = input.trim();
        if(input.contains("yes") || input.equals("y"))
        {
            return "yes";
        }
        else if(input.contains("no") || input.equals("n"))
        {
            return "no";
        }
        else
        {
            return "maybe";
        }
    }
    protected static int battleMenu(Character player,Monster monster)
    {

        System.out.println("* Your health : " + player.health);
        if(monster.health > (monster.stats[4]*15))
        {
            System.out.println("* The monster looks unwounded");
        }
        else if(monster.health > (monster.stats[4] * 10) )
        {
            System.out.println("* The monster looks wounded");
        }
        else
        {
            System.out.println("* The monster looks heavily wounded");
        }

        System.out.println("* 1. Attack!");
        System.out.println("* 2. Use Item.");
        System.out.println("* 3. Use Magic.");
        System.out.println("* 4. Run for your life.");
        Scanner scanner = new Scanner(System.in);
        int output = 0;
        while (output==0)
        {
            String input = "";
            try { input = scanner.nextLine(); } catch(Exception e) {}
            input = input.trim();
            if (input.equals("1")||input.equals("1.")||input.equals("one")) { scanner.close(); output = 1; }
            else if (input.equals("2")||input.equals("2.")||input.equals("two")) { scanner.close(); output = 2; }
            else if (input.equals("3")||input.equals("3.")||input.equals("three")) { scanner.close(); output = 3; }
            else if (input.equals("4")||input.equals("4.")||input.equals("four")) { scanner.close(); output = 4; }                                                                                                                // GEEF LETTER TERUG VAN OPTIE, 3 IS EEN FAAL
            else { System.out.println("* That's not a valid option!"); }
        }
        return output;
    }
    protected static void printInventory(List<Item> inventory) throws NullPointerException
    {
          for(int i = 0;i<inventory.size();i++)
            {
                    System.out.println("* "+(i+1)+ ". " + inventory.get(i).getItemName());
                    System.out.println("*           Price : " + inventory.get(i).getItemPrice());
            }
          if(inventory.size()==0)
            {
              System.out.println("* ---------------------------------------");
              System.out.println("* Inventory is empty!");
              System.out.println("* ---------------------------------------");
            }
    }
    // protected static void printConsumeables(List<Item> inventory) throws NullPointerException
    // {
    //    for(Item item : inventory)
    //       {
    //                int i = 1;
    //                if(item instanceof Consumeables)
    //                {
     //                           Consumeables consumeable = (Consumeables) item;
     //                           System.out.println("* "+ i + ". " + consumeable.itemName);
    //                            System.out.println("*      Healing : " + consumeable.healthHeal);
    //                            System.out.println("*      Mana-ing : " + consumeable.manaHeal);
    //                            i++;
    //                }
    //       }
    //      if(inventory.size()==0)
    //      {
    //          System.out.println("* ---------------------------------------");
    //          System.out.println("* Inventory is empty!");
    //          System.out.println("* ---------------------------------------");
    //      }
    // }
    protected static void inventoryConsumeYN(Character player) throws InterruptedException
    {
        System.out.println("* ---------------------------------------");
        System.out.println("* Press a number to eat the item or any other key to exit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.trim();
        int inputInt = 0;
        try { inputInt = Integer.parseInt(input); } catch ( NumberFormatException e ) { }
        if(inputInt>0 && inputInt <= player.inventory.size() && player.inventory.get(inputInt-1) instanceof Consumeables)
        {
            for (int i=0; i<100; ++i) System.out.println();
            Consumeables consumeable = (Consumeables) player.inventory.get((inputInt-1));;
            consumeable.consume(player);
            System.out.println("* Om nom nom");
            Thread.sleep(1000);
            for (int i=0; i<100; ++i) System.out.println();
        }
        else
        {
            for (int i=0; i<100; ++i) System.out.println();
            System.out.println("* Nevermind then.");
            Thread.sleep(1000);
            for (int i=0; i<100; ++i) System.out.println();
        }
    }
    protected static void printPlayerInventory(Character player)
    {
        System.out.println("* Your inventory");
        MenuPrints.printInventory(player.inventory);
        System.out.println("* ---------------------------------------");
        System.out.println("* Your defense : " + player.playerEqDefense);
        System.out.println("* ---------------------------------------");
        System.out.println("* Your attack : " + player.playerEqDamage);
        System.out.println("* ---------------------------------------");
        System.out.println("* Your money : " + player.money);
        System.out.println("* ---------------------------------------");
        System.out.println("* Your experience : " + player.experience);
        System.out.println("* ---------------------------------------");
        System.out.println("* Your level : " + player.level + " ( experience remaining : " + ((100+((player.level*player.level)*100))-player.experience) + " )");
        System.out.println("* ---------------------------------------");
        System.out.println("* Health : " + player.health);
        System.out.println("* Mana : " + player.mana);
        System.out.println("* ---------------------------------------");
        System.out.println("* Your stats are");
        System.out.println("* Strength      : "+ player.stats[0]);  // IMPLEMENTED
        System.out.println("* Intelligence  : "+ player.stats[1]);  // IMPLEMENTED
        System.out.println("* Agility       : "+ player.stats[2]);  // IMPLEMENTED
        System.out.println("* Willpower     : "+ player.stats[3]);  // NOT IMPLEMENTED
        System.out.println("* Endurance     : "+ player.stats[4]);  // IMPLEMENTED
        System.out.println("* Luck          : "+ player.stats[5]);  // IMPLEMENTED
        System.out.println("* ---------------------------------------");
    }
    protected static int bossBattleMenu(Character player,Boss boss)
    {

        System.out.println("* Your health : " + player.health);
        if(boss.health > (boss.stats[4]*15))
        {
            System.out.println("* The " + boss.race + " looks unwounded");
        }
        else if(boss.health > (boss.stats[4] * 10) )
        {
            System.out.println("* The " + boss.race + " looks wounded");
        }
        else
        {
            System.out.println("* The " + boss.race + " looks heavily wounded");
        }

        System.out.println("* 1. Attack!");
        System.out.println("* 2. Use Item.");
        System.out.println("* 3. Use Magic.");
        Scanner scanner = new Scanner(System.in);
        int output = 0;
        while (output==0)
        {
            String input = scanner.nextLine();
            input = input.trim();
            if (input.equals("1")||input.equals("1.")||input.equals("one")) { scanner.close(); output = 1; }
            else if (input.equals("2")||input.equals("2.")||input.equals("two")) { scanner.close(); output = 2; }
            else if (input.equals("3")||input.equals("3.")||input.equals("three")) { scanner.close(); output = 3; }  // GEEF LETTER TERUG VAN OPTIE, 4 IS EEN FAAL
            else { System.out.println("* That's not a valid option!"); }
        }
        return output;
    }
    protected static String bossBattleMiss(Boss boss)
    {
        if(boss.race=="Pitlord")             return "Your weapon dents off the Pitlord's scale armour.";
        else if(boss.race=="Orc Warlord")    return "The Orc didn't even flinch!";
        else if(boss.race=="Void Fiend")     return "Your weapon travels through the Fiend, seemingly doing nothing";
        else if(boss.race=="Nightmare")      return "The Nightmare skillfully dodges your weapon";
        return "You miss!";
    }
    protected static String bossBattleHit(Boss boss)
    {
        String[] pitlordHit = {"* The Pitlord groans!","* Blood splatters across the floor as you open up an artery!","* You dented the Pitlord's armour."};
        String[] orcHit = {"* The Orc Warlord cries out in pain!","* Agh! Stupid, stupid Humie!"};
        String[] voidFiend = {"* The Fiend emits a hiss as you strike it!","* A part of the Fiend dissapears into thin air!","* The Void Fiend curses in an alien language"};
        String[] nightmareHit = {"* The Nightmare staggers!","* The Nightmare jumps away, but not without a limp."};
        Random random = new Random();
        if(boss.race=="Pitlord")             return pitlordHit[random.nextInt(3)];
        else if(boss.race=="Orc Warlord")    return orcHit[random.nextInt(2)];
        else if(boss.race=="Void Fiend")     return voidFiend[random.nextInt(3)];
        else if(boss.race=="Nightmare")      return nightmareHit[random.nextInt(2)];
        return "You miss!";
    }
    public static void initialize(Character player,Shop beginnerShop,Library beginnerLibrary)
    {
        player.giveMoney(200);             // GEEF 200 coins
        player.spellbook.add(new Spell("Blasts your enemies with fire","Fireball","Exuro tergum quod os",0,10,15));
        beginnerShop.shopInventory.add(new Sword("Bronze Sword","Cuts stuff up real good",50,10,5,false));
        beginnerShop.shopInventory.add(new Axe("Bronze Axe","Hacks stuff up real good",50,10,7,false));
        beginnerShop.shopInventory.add(new Torso("Bronze Plate","Stops stuff from cutting up your torso real good",50,10,5,false));
        beginnerShop.shopInventory.add(new Leggings("Bronze Leggings","Stops stuff from cutting up your leg real good",50,10,3,false));
        beginnerShop.shopInventory.add(new Consumeables("Health Potion","Heals you when you got cut up real good",10,1,25,0,true));
        beginnerShop.shopInventory.add(new Consumeables("Chocolate Cookie","Om nom nom... real good",10,1,5,0,false));
        beginnerShop.shopInventory.add(new Consumeables("Mana Potion","Replenishes mana when you cast up stuff real good",10,1,0,25,true));
        beginnerShop.shopInventory.add(new Consumeables("Rat Poison","Nasty shit that will fuck you up real good",10,1,-10,0,false));
        beginnerLibrary.librarybook.add(new Spell("Freezes your enemies in to submission","Icewave","Congelo somes quod animus",1,20,25));
        beginnerLibrary.librarybook.add(new Spell("Batters your enemies with soil and rock.","Earthspirit","Victus humus pugna",2,40,50));
        beginnerLibrary.librarybook.add(new Spell("Scorches everything it touches in to ash","Hellfire","Perussi estus solis diabolus",0,60,60));
    }
}
