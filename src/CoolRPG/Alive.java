/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CoolRPG;

import java.util.Random;
public abstract class Alive
{
    protected int health;
    protected int mana;
    protected String name;
    protected int[] stats;
    protected int[] weakness;
    public Alive()
    {
       stats = new int[6];
       weakness =  new int[3];
    }
    protected void giveName(String name)
    {
        this.name = name;
    }
    protected int[] giveStats()  // Maakt stats aan
    {
        boolean equalsforty = false;
        Random random = new Random();
        while (!equalsforty)
        {
            for(int i=0;i<6;i++)
            {
                stats[i] =  1 + random.nextInt(10);
            }
            if (stats[0]+stats[1]+stats[2]+stats[3]+stats[4]+stats[5]==40)
            {
                String[] statsname = {"* Strength     : " ,"* Intelligence  : ",
                                      "* Agility       : ","* Willpower     : ",
                                      "* Endurance     : ","* Luck          : "};
                System.out.println("* Your stats are");
                for(int i=0;i<statsname.length;i++)
                {
                    System.out.println(statsname[i] + stats[i]);
                }
                equalsforty = true;
                health = stats[4]*20;
                mana = stats[1]*20;
            }
        }
        return stats;
    }
    protected String getName()
    {
        return name;
    }
    protected int[] getStats()
    {
        return stats;
    }
    protected int getHealth()
    {
        return health;
    }
}

