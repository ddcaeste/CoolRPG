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
public class Boss extends Alive
{
    protected String   race;
    protected String   bossName;
    protected String   bossFamilyName;
    protected String   bossFullName;
    public Boss(Character player)
    {
        super();
        Random generator = new Random();
        boolean done = false;
        while (!done)
        {
            int sphereChoice = generator.nextInt(4);
            if(sphereChoice==0)
            {
                this.race = "Pitlord";
                stats[0]=15; stats[1]=3; stats[2]=4; stats[3]=7; stats[4]=20; stats[5]=5; health = stats[4]*20; mana = stats[1]*20;
                weakness[0]=40; weakness[1]=80; weakness[2]=90;
                String[] bossNames = {"Galvanoth","Magtheridon","Siloth","Xirkos","Arcubus","Makazadron","Abaddon"}; // CREDITS GO TO WARCRAFT 3
                bossName = bossNames[generator.nextInt(7)];
                String[] bossFamilyNames = {"Worldeater","the Slayer","the Brutal","the Infernal","the Despoiler","Deathbringer"};
                bossFamilyName = bossFamilyNames[generator.nextInt(6)];
                bossFullName = bossName + " " + bossFamilyName;
                done = true;
            }
            if(sphereChoice==1)
            {
                this.race = "Orc Warlord";
                stats[0]=20; stats[1]=1; stats[2]=7; stats[3]=2; stats[4]=15; stats[5]=3; health = stats[4]*20; mana = stats[1]*20;
                weakness[0]=60; weakness[1]=40; weakness[2]=40;
                String[] bossNames = {"Gorgutz","Gruumsh","Kurbag","Brishnak","Krart","Gruugdish","Groogz"};
                bossName = bossNames[generator.nextInt(7)];
                String[] bossFamilyNames = {"'Ead 'Unter","Umie Stompa","Blitz Fighta","Hackin' Slasha"};
                bossFamilyName = bossFamilyNames[generator.nextInt(4)];
                bossFullName = bossName + " " + bossFamilyName;
                done = true;
            }
            if(sphereChoice==2)
            {
                this.race = "Void Fiend";
                stats[0]=7; stats[1]=15; stats[2]=10; stats[3]=10; stats[4]=10; stats[5]=12; health = stats[4]*20; mana = stats[1]*20;
                weakness[0]=50; weakness[1]=50; weakness[2]=50;
                String[] bossNames = {"Shax","Vepar","Semiazas","Malphas","Ipos","Nox"};
                bossName = bossNames[generator.nextInt(6)];
                String[] bossFamilyNames = {"the Untrue","the Shatterer","Unbinder","Gazefrost"};
                bossFamilyName = bossFamilyNames[generator.nextInt(3)];
                bossFullName = bossName + " " + bossFamilyName;
                done = true;
            }
            if(sphereChoice==3)
            {
                this.race = "Nightmare";
                stats[0]=15; stats[1]=10; stats[2]=20; stats[3]=11; stats[4]=15; stats[5]=15; health = stats[4]*20; mana = stats[1]*20;
                weakness[0]=40; weakness[1]=80; weakness[2]=60;
                String[] bossNames = {"Voidracer","Furymane","Soulbreaker"};
                bossName = bossNames[generator.nextInt(3)];
                String[] bossFamilyNames = {"the Infernal","the Terrifying","the Bonebreaker"};
                bossFamilyName = bossFamilyNames[generator.nextInt(3)];
                bossFullName = bossName + " " + bossFamilyName;
                done = true;
            }
        }
    }
}

