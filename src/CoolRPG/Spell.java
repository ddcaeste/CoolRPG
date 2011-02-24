/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CoolRPG;

/**
 *
 * @author UGent
 */
public class Spell
{
    protected int element; // 0 FIRE 1 WATER 2 EARTH
    protected String description;
    protected String name;
    protected String incantation;
    protected int power;
    protected int manacost;
    protected int price;
    public Spell(String description,String name,String incantation,int element,int power,int manacost)
    {
        this.element = element;
        this.description = description;
        this.power = power;
        this.manacost = manacost;
        this.name = name;
        this.incantation = incantation;
        price =  power*5-(manacost/2);
    }
}
