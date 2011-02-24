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
                System.out.println("* Your stats are");
                System.out.println("* Strength      : "+stats[0]);
                System.out.println("* Intelligence  : "+stats[1]);
                System.out.println("* Agility       : "+stats[2]);
                System.out.println("* Willpower     : "+stats[3]);
                System.out.println("* Endurance     : "+stats[4]);
                System.out.println("* Luck          : "+stats[5]);
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
