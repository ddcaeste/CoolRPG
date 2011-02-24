/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CoolRPG;

/**
 *
 * @author UGent
 */
import java.util.Random;
import java.util.Scanner;
public class Battle
{
    protected static Random random;
    protected static boolean won;
    public static boolean battleStarts(Character player, Monster monster) throws InterruptedException
    {
        String monsterString = monster.trait + " " + monster.color + " " + monster.name;
        if(monster.trait==""){ monsterString = monster.color + " " + monster.name; }
        System.out.println("* A wild " + monsterString + " appears!");
        while(player.health>0&&monster.health>0)
        {
            int choice = MenuPrints.battleMenu(player,monster);
            won = true;
            random = new Random();
            if(choice==1) //ATTACK
            {
                System.out.println("* Swoosh.");
                int hitchance;
                int hit;
                if(player.stats[2]-monster.stats[2]<0) hitchance = 2;
                else hitchance = 2 + player.stats[2]-monster.stats[2];
                int hityesorno = random.nextInt(hitchance);
                try { hit = ((player.playerEqDamage + player.stats[0]) * (2+(random.nextInt(5)/2)) / hityesorno) * hityesorno; }
                catch (ArithmeticException e) { hit = 0; }  // MISS WANT DIVIDED BY ZERO :D
                monster.health = monster.health - hit;
                if(hit==0)  {   System.out.println("* You miss the " + monsterString + "! D:");     }
                else if(hit==42) {   System.out.println("* You give this monster the answer to the question.");                                              } // FIRST EASTER EGG
                else        {   System.out.println("* You hit the " + monsterString  + " for " + hit + " points of damage! :D");     }

                if(monster.stats[2]-player.stats[2]<0) hitchance = 2;
                else hitchance = 2 + monster.stats[2]-player.stats[2];
                hityesorno = random.nextInt(hitchance);
                try { hit =((((monster.stats[0]*(1+ random.nextInt(5)))-(player.playerEqDefense*(1+random.nextInt(3))))/hityesorno)*hityesorno); }
                catch (ArithmeticException e) { hit = 0; } // MISS WANT DIVIDED BY ZERO :D
                if (hit < 0)    hit = 0;
                player.health = player.health - hit;
                if(hit==0){ System.out.println("* The " + monsterString + " has missed you! :D"); }
                else { System.out.println("* You have been hit for " + hit + " points of damage! D:"); }
                Thread.sleep(1000);
                for (int i=0; i<100; ++i) System.out.println();
            }
            if(choice==2) //OMNOMNONMONMNONMONNOMNOMNONM
            {
                for (int i=0; i<100; ++i) System.out.println();
                MenuPrints.printInventory(player.inventory);
                MenuPrints.inventoryConsumeYN(player);
            }
            if(choice==3)
            {
                for (int i=0; i<100; ++i) System.out.println();
                Library.writeSpellInventory(player.spellbook,false);
                Scanner scanner = new Scanner(System.in);
                Random random = new Random();
                String input = scanner.nextLine();
                for (int i=0; i<100; ++i) System.out.println();
                input = input.trim();
                int inputInt = 0;
                try { inputInt = Integer.parseInt(input); } catch ( NumberFormatException e ) { }
                if(inputInt>0 && inputInt <= player.spellbook.size() )
                {
                    Spell castedSpell = player.spellbook.get(inputInt-1);
                    if(player.mana>=castedSpell.manacost)
                    {
                        player.mana = player.mana - castedSpell.manacost;
                        int randommodfier = 1 + (random.nextInt(10)/10);
                        int hit = (castedSpell.power*(monster.weakness[castedSpell.element])/100)*randommodfier;
                        monster.health = monster.health - hit;
                        System.out.println("* " + castedSpell.incantation + "...");
                        System.out.println("* You hit the " + monsterString  + " for " + hit + " points of damage! :D");
                        hit = (monster.stats[0]*random.nextInt(5)) - (player.playerEqDefense*random.nextInt(3));
                        if (hit < 0) { hit = 0; }
                        player.health = player.health - hit;
                        if(hit==0){ System.out.println("* The " + monsterString + " has missed you! :D"); }
                        else { System.out.println("* You have been hit for " + hit + " points of damage! D:"); }
                        Thread.sleep(1000);
                    }
                    else
                    {
                        System.out.println("You need more mana!");
                    }
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
            if(choice==4) //RUNFORTHEELIFE
            {
                if(player.stats[2]*random.nextInt(3)>=monster.stats[2]*random.nextInt(2))
                {
                    // LOL XD COWARD
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* Got away safely!");
                    Thread.sleep(1000);
                    for (int i=0; i<100; ++i) System.out.println();
                    return true;
                }
                else
                {
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* The " + monsterString + " is not amused.");
                    int hit = (monster.stats[0]*random.nextInt(5)) - (player.playerEqDefense*random.nextInt(3));
                    if (hit < 0) { hit = 0; }
                    player.health = player.health - hit;
                    if(hit==0){ System.out.println("* The " + monsterString + " has missed you! :D"); }
                    else { System.out.println("* You have been hit for " + hit + " points of damage! D:"); }
                    Thread.sleep(2000);
                    for (int i=0; i<100; ++i) System.out.println();
                }
            }
        }
        if(player.health<=0)
        {
            System.out.println("* You have been slain in combat!");
            Thread.sleep(3000);
            for (int i=0; i<100; ++i) System.out.println();
            return false;
        }
        if(monster.health<=0)
        {
            System.out.println("* You have slain the " + monsterString + " !");
            won = true;
            int phatlewt = 0;
            phatlewt = ( ( 2 + random.nextInt(9)) * ( 1 + ( random.nextInt(player.stats[5]*10 ) /10) ));
            System.out.println("* You loot " + phatlewt + " coins from the " + monsterString + ".");
            player.money += phatlewt;
            Item gottenItem = Lootlist.lootGenerate();
            player.inventory.add(gottenItem);
            player.initializeEquipment();
            System.out.println("* You found a " + gottenItem.itemName);
            // REHEAL CHEAT ;D
            player.experience = player.experience + monster.stats[4]*20;
            System.out.println("* You gain " + monster.stats[4]*20 + " experience!");                                    // MAKE A CHECK EXP AND LEVEL UP THING IN THE FUTURE :D
            while(player.experience>= (100+((player.level*player.level)*100)))
            {
                player.experience = player.experience - (100+((player.level*player.level)*100));
                player.levelUp();
                System.out.println("* You have gained a level!!! :)");
                System.out.println("* Your level now is : " + player.level);
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
            }
        }
        return won;
    }
    public static boolean bossBattle(Character player, Boss boss) throws InterruptedException
    {
        Texts.printIntro(boss);
        while(player.health>0&&boss.health>0)
        {
            int choice = MenuPrints.bossBattleMenu(player,boss);
            boolean won = true;
            Random random = new Random();
            if(choice==1) //ATTACK
            {
                System.out.println("* Swoosh.");
                int hitchance;
                int hit = 0;
                if(player.stats[2]-boss.stats[2]<0) hitchance = 2;
                else hitchance = 2 + player.stats[2]-boss.stats[2];
                int hityesorno = random.nextInt(hitchance);
                try { hit = ((player.playerEqDamage + player.stats[0]) * (2+(random.nextInt(5)/2)) / hityesorno)*hityesorno; }
                catch (ArithmeticException e) { hit = 0; }  // MISS WANT DIVIDED BY ZERO :D
                boss.health = boss.health - hit;
                if(hit==0)      System.out.println(MenuPrints.bossBattleMiss(boss));
                else            System.out.println(MenuPrints.bossBattleHit(boss)); System.out.println("* You hit the " + boss.race  + " for " + hit + " points of damage! :D");

                if(boss.stats[2]-player.stats[2]<0) hitchance = 2;
                else hitchance = 2 + boss.stats[2]-player.stats[2];
                hityesorno = random.nextInt(hitchance);
                try { hit =((((boss.stats[0]*(1+ random.nextInt(5)))-(player.playerEqDefense*(1+random.nextInt(3))))/hityesorno)*hityesorno); }
                catch (ArithmeticException e) { hit = 0; } // MISS WANT DIVIDED BY ZERO :D
                if (hit < 0)    hit = 0;
                player.health = player.health - hit;
                if(hit==0)      System.out.println("* The " + boss.race + " has missed you!");
                else            System.out.println("* The " + boss.race + " has hit you for " + hit + " points of damage!");
                Thread.sleep(1500);
                for (int i=0; i<100; ++i) System.out.println();
            }
            if(choice==2) //OMNOMNONMONMNONMONNOMNOMNONM
            {
                for (int i=0; i<100; ++i) System.out.println();
                MenuPrints.printInventory(player.inventory);
                MenuPrints.inventoryConsumeYN(player);
            }
            if(choice==3)
            {
                for (int i=0; i<100; ++i) System.out.println();
                Library.writeSpellInventory(player.spellbook,false);
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                for (int i=0; i<100; ++i) System.out.println();
                input = input.trim();
                int inputInt = 0;
                try { inputInt = Integer.parseInt(input); } catch ( NumberFormatException e ) { }
                if(inputInt>0 && inputInt <= player.spellbook.size() )
                {
                    Spell castedSpell = player.spellbook.get(inputInt-1);
                    if(player.mana>=castedSpell.manacost)
                    {
                        player.mana = player.mana - castedSpell.manacost;
                        int randommodfier = 1 + (random.nextInt(10)/10);
                        int hit = (castedSpell.power*(boss.weakness[castedSpell.element])/100)*randommodfier;
                        boss.health = boss.health - hit;
                        System.out.println("* " + castedSpell.incantation + "...");
                        System.out.println("* You hit the " + boss.race  + " for " + hit + " points of damage! :D");
                        hit = (boss.stats[0]*random.nextInt(5)) - (player.playerEqDefense*random.nextInt(3));
                        if (hit < 0) { hit = 0; }
                        player.health = player.health - hit;
                        if(hit==0){ System.out.println("* The " + boss.race + " has missed you! :D"); }
                        else { System.out.println("* You have been hit for " + hit + " points of damage! D:"); }
                        Thread.sleep(1000);
                    }
                    else
                    {
                        System.out.println("You need more mana!");
                    }
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
        }
        if(player.health<=0)
        {
            won = false;
            for (int i=0; i<100; ++i) System.out.println();
            System.out.println("You have been defeated!");
            // DEFEAT MESSAGE
        }
        else if(boss.health<=0)
        {
            for (int i=0; i<100; ++i) System.out.println();
            System.out.println("* You have slain " + boss.bossFullName + ", the " + boss.race + " !");
            System.out.println("* You are a true hero, worthy to be written down in the books of history!");
            Thread.sleep(5000);
            for (int i=0; i<100; ++i) System.out.println();
            won = true;
            // int phatlewt = 200;
            // System.out.println("* You loot " + phatlewt + " coins from the " + monsterString + ".");             GAME ENDS
            // player.money += phatlewt;
            // REHEAL CHEAT ;D
            // player.experience = player.experience + monster.stats[4]*20;
            // System.out.println("* You gain " + monster.stats[4]*20 + " experience!");
            // while(player.experience>= (100+((player.level*player.level)*100)))
            // {
            //  player.experience = player.experience - (100+((player.level*player.level)*100));
            //  player.levelUp();
            //  System.out.println("* You have gained a level!!! :)");
            //  System.out.println("* Your level now is : " + player.level);// VICCTORY MESSAGE + LOOT
            // }
        }
        return won;
    }
}
