import java.util.List;
import java.util.ArrayList;
public class Character extends Alive
{
    protected int money;
    protected int experience;
    protected int level;
    protected int playerEqDamage;
    protected int playerEqDefense;
    protected List<Item> inventory;
    protected List<Spell> spellbook;
    public Character()
    {   
        inventory = new ArrayList<Item>();
        spellbook = new ArrayList<Spell>();
        playerEqDamage = 1;
        playerEqDefense = 1;
        weakness[0]=50;weakness[1]=50;weakness[2]=50;
    }
    protected void giveInventory(List<Item> inventory)
    {
        this.inventory = inventory;    
    }
    protected void giveMoney(int money)
    {
        this.money = money;
    } 
    protected int getExperience()
    {
        return experience;
    }
    protected int getLevel()
    {
        return level;
    }
        
    public void addItem(Item item)
    {
        inventory.add(item);
    }
    public Item getIndexItem(int i)
    {
        return inventory.get(i);   
    }
    public Item getItem(Item item)
    {
        for(int i = 0; i<inventory.size();i++)
        {
            if(inventory.get(i).hashCode()==(item.hashCode()))
            {
                return inventory.get(i);
            }
        }
        return null;
    }
    public void initializeEquipment()
    {
        playerEqDamage = 1;
        playerEqDefense = 1;
        int torso = 1;
        int helmet = 0;
        int leggings = 0;
        int boots = 0;
        for(Item item : inventory)
        { 
            if(item instanceof Weapon)
            {
                if(playerEqDamage<item.getItemBuff())
                {
                    playerEqDamage = item.getItemBuff();        
                }
            }
            if(item instanceof Armour)
            {
                if(item instanceof Torso)
                {
                    if(torso<item.getItemBuff())
                    {
                       torso = item.getItemBuff();        
                    }       
                }
                if(item instanceof Helmet)
                {
                 if(helmet<item.getItemBuff())
                    {
                       helmet = item.getItemBuff();        
                    }     
                }
                if(item instanceof Leggings)
                {
                    if(leggings<item.getItemBuff())
                    {
                       leggings = item.getItemBuff();        
                    }     
                }
                if(item instanceof Boots)
                {
                 if(boots<item.getItemBuff())
                    {
                       boots = item.getItemBuff();        
                    }     
                }
                playerEqDefense = boots+helmet+torso+leggings;
            }
        }
    }
    public void levelUp()
    {
           this.level++;
           this.stats[0]++;
           this.stats[1]++;
           this.stats[2]++;
           this.stats[3]++;
           this.stats[4]++;
           this.stats[5]++;
           this.health =   this.stats[4]*20;
           this.mana   =   this.stats[1]*20;    
    }
}

