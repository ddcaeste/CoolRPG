/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CoolRPG;

/**
 *
 * @author UGent
 */
public abstract class Weapon extends Item
{
    protected int itemDamage;
    protected Weapon(String itemName, String itemDescription, int itemPrice, int itemWeight,int itemDamage,boolean shopRespawn)
    {
        super(itemName, itemDescription,itemWeight, itemPrice,shopRespawn);
        this.itemBuff = itemDamage;
    }
    public int getItemDamage()
    {
        return itemBuff;
    }
}