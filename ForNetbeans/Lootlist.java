import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class Lootlist
{
    public static Item lootGenerate()
    {
        Random random = new Random();
        int lucky = 1+random.nextInt(3);
        Item loot;
        if(lucky==1)
        {
            loot = new Helmet("Iron Helmet","Protects your head",60,7,4,false); return loot;     
        }
        else if(lucky==2)
        {
            loot = new Sword("Iron Sword","Cuts up stuff even better",60,20,8,false); return loot;    
        }
        else if(lucky==3)
        {
            loot = new Torso("Iron Plate","Better than usual protection.",100,25,10,false); return loot;         
        }
        else System.out.println("You broke the damn system, gratz."); return null;

    }
}
