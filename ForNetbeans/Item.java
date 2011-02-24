public abstract class Item
{
    protected String itemName;
    protected String itemDescription;
    protected int itemPrice;
    protected int itemWeight;
    protected int itemBuff;
    protected boolean shopRespawn;
    public Item(String itemName,String itemDescription,int itemPrice,int itemWeight,boolean shopRespawn)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemWeight = itemWeight;
        this.itemDescription = itemDescription;
        this.shopRespawn = shopRespawn;
    }
    
    public void setItemName(String itemName)
    {
            this.itemName = itemName;
    }
    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }
    public void setItemPrijs(int itemPrice)
    {
        this.itemPrice = itemPrice;
    }
    public void setItemWeight(int itemWeight)
    {
        this.itemWeight = itemWeight;
    }
    
    
    public String getItemName()
    {
        return itemName;    
    }
    public String getItemDescription()
    {
        return itemDescription;    
    }
    public int getItemPrice()
    {
        return itemPrice;
    }
    public int getItemWeight()
    {
        return itemWeight;
    }
    public int getItemBuff()
    {
        return itemBuff;    
    }
}
