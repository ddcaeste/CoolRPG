public abstract class Armour extends Item
{
    protected int itemDefense;
    protected String itemBodyPlace;
    protected Armour(String itemName, String itemDescription,int itemPrice, int itemWeight,int itemDefense,boolean shopRespawn)
    {
        super(itemName, itemDescription,itemPrice, itemWeight,shopRespawn);
        this.itemBuff = itemDefense;
    }
    public int getItemDefense()
    {
        return itemBuff;    
    }
}