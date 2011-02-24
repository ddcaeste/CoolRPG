public class Consumeables extends Item
{
    protected int healthHeal;
    protected int manaHeal;
    public Consumeables(String itemName,String itemDescription,int itemPrice,int itemWeight,int healthHeal,int manaHeal,boolean shopRespawn)
    {
        super(itemName,itemDescription,itemPrice,itemWeight,shopRespawn);  
        this.healthHeal = healthHeal;
        this.manaHeal = manaHeal;
    }
    public void consume(Character player)
    {
            player.health = player.health + healthHeal;
            if(player.stats[4]*20 < player.health)
            {
                player.health = player.stats[4]*20;    
            }
            player.mana = player.mana + manaHeal;
            if(player.stats[1]*20 < player.mana)
            {
                player.mana = player.stats[1]*20;    
            }
            player.inventory.remove(this);
    }
}
